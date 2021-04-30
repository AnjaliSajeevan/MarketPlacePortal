/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pojo;

import java.util.Date;
import org.springframework.stereotype.Component;

/**
 *
 * @author Anjali
 */
@Component
public class Orders {
    private int orderid;
    private double total;
    private int quantity;
    private String date;
    private User user;

    public Orders() {
    }

    
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    


    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

   

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    
}
