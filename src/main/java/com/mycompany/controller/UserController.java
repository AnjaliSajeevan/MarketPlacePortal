/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.dao.ProductDao;
import com.mycompany.dao.UserDao;
import com.mycompany.exceptionHandling.AdException;
import com.mycompany.pojo.Category;
import com.mycompany.pojo.Product;
import com.mycompany.pojo.User;
import com.mycompany.validator.UserValidator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Anjali
 */
@Controller
public class UserController {


    private UserDao userdao;
    private ProductDao productDao;
    private UserValidator userValidator;

    @Autowired
    public UserController(UserDao userdao, ProductDao productDao,UserValidator userValidator) {
        this.userdao = userdao;
        this.productDao = productDao;
        this.userValidator = userValidator;
    }
    
      @RequestMapping(value={"/skye","/","/index"})
    public ModelAndView home() throws AdException{
        ModelAndView mv= new ModelAndView("usermainPage");
        List<Product> productList = productDao.getProductList();
        mv.addObject("products", productList);
        mv.addObject("title","Home");
        mv.addObject("clickHome",true);
        return mv;
    }
    
      @RequestMapping(value="/login")
    public ModelAndView login(){
        ModelAndView mv= new ModelAndView("usermainPage");
        mv.addObject("title","Login");
        mv.addObject("clickLogin",true);
        return mv;
    }
    
     @RequestMapping(value="/login",method = RequestMethod.POST)
    public ModelAndView handleRequestInternal(HttpServletRequest request,HttpSession session, SessionStatus status) throws Exception {
        ModelAndView mv = null;
         String email = request.getParameter("email");
         String password = request.getParameter("password");
        List<Product> productList = productDao.getProductList();
        User user=userdao.loginCheck(email,password);
       
        userdao.close();
        status.setComplete();
        if(user!=null){
            
            session.setAttribute("email", user.getEmail());
            if(user.getRole().equals("customer")){
                session.setAttribute("role", "customer");
                mv= new ModelAndView("redirect:/Customer/homepage");
            }if(user.getRole().equals("seller")){
                session.setAttribute("role", "seller");
                mv= new ModelAndView("redirect:/Seller/sellerHomePage");
            }
        }else{
         mv= new ModelAndView("usermainPage");
         mv.addObject("loginfailed",true);
         mv.addObject("title","Login");
         mv.addObject("clickLogin",true);
         session.setAttribute("role", "noRole");
        }
        
        return mv;
    }
    
         @RequestMapping(value="/register", method = RequestMethod.GET)
    public ModelAndView register(@ModelAttribute("users") User users,HttpServletRequest request,SessionStatus status) throws AdException{
        ModelAndView mv= new ModelAndView("usermainPage");
         
        mv.addObject("title","Register");
        mv.addObject("clickRegister",true);
        return mv;
    }
    
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String userRegistration(@Valid @ModelAttribute("users") User users, BindingResult result, Model model, HttpServletRequest request ) throws AdException {
        boolean output = false;
        ModelAndView mv = new ModelAndView("usermainPage");
        String email = request.getParameter("email");
        
        System.out.println( "UserValidation:"+userValidator);
        userValidator.validate(users, result);
        if (result.hasErrors()) {
            model.addAttribute("title", "Register");
            model.addAttribute("clickRegister", true);
            return "usermainPage";
        }
        User userCheck = userdao.checkEmail(email);
        if (userCheck == null) {
            output = userdao.addUser(users);
            userdao.close();
            mv.addObject("Registered", true);
            return "redirect:/login";
        } 

        return "redirect:/register";

    
    }
}
