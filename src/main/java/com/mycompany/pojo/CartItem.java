/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pojo;

import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Component;

/**
 *
 * @author Anjali
 */
@Component
public class CartItem {
    private int cartItemid;
    private int quantity;
    private int orderid;
    private double totalPrice;
    private Product product;
    private Cart cart;




    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }
    

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
     

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
    
    

    public int getCartItemid() {
        return cartItemid;
    }

    public void setCartItemid(int cartItemid) {
        this.cartItemid = cartItemid;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

}
