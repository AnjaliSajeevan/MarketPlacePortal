/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import static com.mycompany.dao.DAO.getSession;
import com.mycompany.exceptionHandling.AdException;
import com.mycompany.pojo.Address;
import com.mycompany.pojo.Cart;
import com.mycompany.pojo.CartItem;
import com.mycompany.pojo.Product;
import com.mycompany.pojo.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Anjali
 */
@Component
public class CartDao extends DAO{
    
    
       public boolean addCart(Cart cart) throws AdException{
        boolean result=false;
        try{
        beginTransaction();
            getSession().save(cart);
            commit();
            result=true;
             return result;
        } catch (HibernateException e) {
               rollback();
               throw new AdException("Exception while creating cart: " + e.getMessage());
           } 
       
    }
       
           public void delete(Cart cart) throws AdException {
        try {
           beginTransaction();
            getSession().delete(cart);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not delete user " + cart.getCartid(), e);
        }
           }
       
    

     
     public void updateCart(Cart cart) throws AdException {
        try{
        beginTransaction();
        Session s=getSession();
        s.clear();
        s.update(cart);
        commit();
        } catch (HibernateException e) {
               rollback();
               throw new AdException("Exception while updating cart: " + e.getMessage());
           } 
        }
     
         public Cart getCart(User user) throws AdException{
     try{
        beginTransaction();
        String hql = "FROM Cart where user = : user";
        Query query = getSession().createQuery(hql);
        query.setParameter("user", user);
        Cart cart = (Cart) query.uniqueResult();
        commit();
        return cart;
        } catch (HibernateException e) {
               rollback();
               throw new AdException("Exception while creating user: " + e.getMessage());
           } 
    }
    
}
