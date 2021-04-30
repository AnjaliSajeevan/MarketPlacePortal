/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pojo;

import org.springframework.stereotype.Component;

/**
 *
 * @author Anjali
 */
@Component
public class OrderItem {
    private int orderItemid;
     private Orders orders;
     private Product product;
     private double price;
     private String status;
     private int quantity;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

     

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public OrderItem() {
    }

    public int getOrderItemid() {
        return orderItemid;
    }

    public void setOrderItemid(int orderItemid) {
        this.orderItemid = orderItemid;
    }


}
