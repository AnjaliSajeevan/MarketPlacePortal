/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exceptionHandling;

import com.sun.org.slf4j.internal.LoggerFactory;
import java.sql.SQLException;
import java.util.logging.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 *
 * @author Anjali
 */

@ControllerAdvice
public class GlobalExceptionHandler {
   
@ExceptionHandler(NoHandlerFoundException.class)
public ModelAndView noHandlerException(){
    ModelAndView mv = new ModelAndView("errorpage");
    mv.addObject("error","Page not available");
    mv.addObject("title","404 Error");
    return mv;
}
}