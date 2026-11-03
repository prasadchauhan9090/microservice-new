package com.chauhan.in.orderservice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data

public class OrderRequest {

    private List<OrderLineItemsDto>  orderLineItemsDtoList;

    public OrderRequest()
    {

    }

    public OrderRequest(List<OrderLineItemsDto> orderLineItemsDtoList) {
        this.orderLineItemsDtoList = orderLineItemsDtoList;
    }
}
