/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pojo;

import javax.validation.constraints.NotEmpty;
import org.springframework.stereotype.Component;

/**
 *
 * @author Anjali
 */
@Component
public class Address {
    private int addressid;
    @NotEmpty(message="Please enter the appartment no.!")
    private String apartment;
    @NotEmpty(message="Please enter the street!")
    private String street;
    @NotEmpty(message="Please enter the city!")
    private String city;
    @NotEmpty(message="Please enter the state!")
    private String state;
    @NotEmpty(message="Please enter the country!")
    private String country;
    @NotEmpty(message="Please enter the zipCode!")
    private String zipCode;
    
    private boolean shipping;
    private boolean billing;
    private User user;

    public Address() {
    }

    public int getAddressid() {
        return addressid;
    }

    public void setAddressid(int addressid) {
        this.addressid = addressid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public boolean isShipping() {
        return shipping;
    }

    public void setShipping(boolean shipping) {
        this.shipping = shipping;
    }

    public boolean isBilling() {
        return billing;
    }

    public void setBilling(boolean billing) {
        this.billing = billing;
    }
    
}
