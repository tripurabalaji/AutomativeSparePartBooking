package com.example.AutomativeSparePartBooking.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.Date;

@Entity(name = "orders")
public class Orders extends BaseModel{

    private Date orderDate;


    private Long Price;
    private int Quantity;
    private OrderStatus orderStatus;

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Long getPrice() {
        return Price;
    }

    public void setPrice(Long price) {
        Price = price;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Orders() {
    }

    public Orders(Date orderDate, Long price, int quantity, OrderStatus orderStatus) {
        this.orderDate = orderDate;
        Price = price;
        Quantity = quantity;
        this.orderStatus = orderStatus;
    }


    /*  @ManyToOne(targetEntity = Users.class)
    private Users user;*/
}
