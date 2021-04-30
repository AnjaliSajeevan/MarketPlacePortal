/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.validator;

import com.mycompany.pojo.Product;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author Anjali
 */
@Component
public class ProductValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Product.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
      Product product =(Product)target;
      
      if(product.getFile()==null || product.getFile().getOriginalFilename().equals("")){
          errors.rejectValue("file", null,"Please upload an image!");
          return;
      }
      if(!(product.getFile().getContentType().equals("image/jpeg")||(product.getFile().getContentType().equals("image/png"))||(product.getFile().getContentType().equals("image/jpg")))){
         errors.rejectValue("file", null,"Please upload a image of jpg,jpeg or png format!");
          return; 
      }
    }
    
}
