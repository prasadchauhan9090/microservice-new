package com.chauhan.in.orderservice.service;

import com.chauhan.in.orderservice.dto.OrderLineItemsDto;
import com.chauhan.in.orderservice.dto.OrderLineItemsDto;
import com.chauhan.in.orderservice.dto.OrderRequest;

import com.chauhan.in.orderservice.model.Order;
import com.chauhan.in.orderservice.model.OrderLineItems;
import com.chauhan.in.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class
OrderService {

    public OrderService(OrderRepository orderRepository, WebClient webClient) {
        this.orderRepository = orderRepository;
        this.webClient = webClient;
    }

    private OrderRepository orderRepository;

    private final WebClient webClient;

    public void placeOrder(OrderRequest orderRequest) {


       Order order = new Order();

       order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(this::mapToDto)
                .toList();

        order.setOrderLineItemList(orderLineItems);

        List<String> skuCodes = order.getOrderLineItemList().stream()
                .map(OrderLineItems::getSkuCode)
                .toList();

        //call inventory service and place order if product is in stock
        Boolean result = webClient.get().uri("http://localhost:8082/api/inventory",
                        uriBuilder -> uriBuilder.queryParam("skuCode",skuCodes).build())
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();

        if(result)
        {
            orderRepository.save(order);
        }
        else {
            throw new IllegalArgumentException("Product is not in stock, please try again later");
        }

        orderRepository.save(order);


    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemDto) {

        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItems.getPrice());
        orderLineItems.setQuantity(orderLineItems.getQuantity());
        orderLineItems.setSkuCode(orderLineItems.getSkuCode());
        return orderLineItems;

    }
}
