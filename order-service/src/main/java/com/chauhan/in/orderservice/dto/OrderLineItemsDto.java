package com.chauhan.in.orderservice.dto;
import lombok.*;

import java.math.BigDecimal;

@Data

public class OrderLineItemsDto {


    private Long id;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;

    public OrderLineItemsDto() {

    }

    public OrderLineItemsDto(Integer quantity, String skuCode, Long id, BigDecimal price) {
        this.quantity = quantity;
        this.skuCode = skuCode;
        this.id = id;
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderLineItemDto{" +
                "id=" + id +
                ", skuCode='" + skuCode + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
