/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.validator;

import com.mycompany.dao.UserDao;
import com.mycompany.exceptionHandling.AdException;
import com.mycompany.pojo.User;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author Anjali
 */
@Component
public class UserValidator implements Validator{

    @Autowired
    UserDao userdao;

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
      User user =(User)target;
       User usercheck = null;
      String regex = "^(.+)@(.+)$";
String regex1 = "^(?=.*[0-9])"
                       + "(?=.*[a-z])(?=.*[A-Z])"
                       + "(?=.*[@#$%^&+=])"
                       + "(?=\\S+$).{6,8}$";
      Pattern pattern = Pattern.compile(regex);
      Matcher matcher = pattern.matcher(user.getEmail());
      
      if(matcher.matches()==false ){
          errors.rejectValue("email", null,"Please enter a valid email!");
          return;
      }
      
      if(user.getEmail().equals("")){
          errors.rejectValue("email", null,"Please enter an email address!");
          return;
      }
      
      Pattern pattern1 = Pattern.compile(regex1);
      Matcher matcher1 = pattern1.matcher(user.getPassword());
      if(matcher1.matches()==false ){
          errors.rejectValue("password", null,"Please enter a password with 6-8 digits , an uppercase alphabet, a lowercase alphabet, a special character and atleast a digit once!");
          return;
      }
      
      if(user.getPassword().equals("")){
          errors.rejectValue("password", null,"Please enter a password!");
            return;
        }

 if(user.getContact().equals("")){
          errors.rejectValue("contact", null,"Please enter a contact number!");
            return;
        }
 
        try {
           usercheck= userdao.checkEmail(user.getEmail());
        } catch (AdException ex) {
            Logger.getLogger(UserValidator.class.getName()).log(Level.SEVERE, null, ex);
        }
         
       if(usercheck!=null)  {
          errors.rejectValue("email", null,"The email id already exist!");
            return;
        }

}
}
