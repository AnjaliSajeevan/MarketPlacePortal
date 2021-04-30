/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pojo;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import org.springframework.stereotype.Component;

/**
 *
 * @author Anjali
 */
@Component
public class Cart {
    private int cartid;
    private double total;
    private User user;
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

   
    public Cart() {
    }
    
    public Cart(User user) {
        this.user = user;
    }

    public int getCartid() {
        return cartid;
    }

    public void setCartid(int cartid) {
        this.cartid = cartid;
    }


    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
}
