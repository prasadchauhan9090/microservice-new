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

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class OrderService {

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    private OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest) {


       Order order = new Order();

       order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(this::mapToDto)
                .toList();

        order.setOrderLineItemList(orderLineItems);

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
