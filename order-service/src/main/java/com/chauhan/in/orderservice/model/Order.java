package com.chauhan.in.orderservice.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="t_orders")

public class Order {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String orderNumber;
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderLineItems> orderLineItemList;

    public Order() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public List<OrderLineItems> getOrderLineItemList() {
        return orderLineItemList;
    }

    public void setOrderLineItemList(List<OrderLineItems> orderLineItemList) {
        this.orderLineItemList = orderLineItemList;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderNumber='" + orderNumber + '\'' +
                ", orderLineItemList=" + orderLineItemList +
                '}';
    }

    public Order(Long id, String orderNumber, List<OrderLineItems> orderLineItemList) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.orderLineItemList = orderLineItemList;
    }
}
