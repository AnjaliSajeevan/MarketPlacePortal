/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author Anjali
 */
public class sellerInterceptor extends HandlerInterceptorAdapter {

   

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String role = (String) request.getSession().getAttribute("role");
//        System.out.println("role"+role);
        if(!role.equals("seller")){
            request.getRequestDispatcher("/WEB-INF/jsp/noaccess.jsp").forward(request,response);
            return false;
        }
        
        return true;
        
//        return super.preHandle(request, response, handler); 
 
    }
    
}
