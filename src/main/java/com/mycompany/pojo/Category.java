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
public class Category {
     private int categoryid;
      @NotEmpty(message="Please enter the name of the department!")
    private String name;
       @NotEmpty(message="Please enter the description for the department!")
    private String description;


    public Category() {
    }

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
 
}
