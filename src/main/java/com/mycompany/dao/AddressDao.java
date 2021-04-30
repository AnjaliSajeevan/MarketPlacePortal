/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import static com.mycompany.dao.DAO.getSession;
import com.mycompany.exceptionHandling.AdException;
import com.mycompany.pojo.Address;
import com.mycompany.pojo.Product;
import com.mycompany.pojo.User;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

/**
 *
 * @author Anjali
 */
@Component
public class AddressDao extends DAO {
    
    public boolean addShippingAddress(Address address) throws AdException{
        boolean result=false;
        try{
        beginTransaction();
            getSession().save(address);
            commit();
            result=true;
             return result;
        } catch (HibernateException e) {
               rollback();
               throw new AdException("Exception while creating user: " + e.getMessage());
           } 
       
    }
    
        public boolean addBillingAddress(Address address) throws AdException{
        boolean result=false;
        try{
        beginTransaction();
            getSession().save(address);
            commit();
            result=true;
             return result;
        } catch (HibernateException e) {
               rollback();
               throw new AdException("Exception while creating user: " + e.getMessage());
           } 
       
    }
    
    
    
    public Address getShippingAddress(User user) throws AdException{
     try{
        beginTransaction();
        String hql = "FROM Address where (user = : user) AND shipping = true";
        Query query = getSession().createQuery(hql);
        query.setParameter("user", user);
        Address address = (Address) query.uniqueResult();
        commit();
        return address;
        } catch (HibernateException e) {
               rollback();
               throw new AdException("Exception while creating user: " + e.getMessage());
           } 
    }
     
      public Address getBillingAddress(User user) throws AdException{
     try{
        beginTransaction();
        String hql = "FROM Address where (user = : user) AND billing = true";
        Query query = getSession().createQuery(hql);
        query.setParameter("user", user);
        Address address = (Address) query.uniqueResult();
        commit();
        System.out.println(address);
        return address;
        } catch (HibernateException e) {
               rollback();
               throw new AdException("Exception while creating user: " + e.getMessage());
           } 
    }
      
       public void updateShippingAddress(User user) throws AdException{
        try{
        beginTransaction();
        getSession().update(user);
        commit();
        } catch (HibernateException e) {
               rollback();
               throw new AdException("Exception while creating user: " + e.getMessage());
           } 
        }
       
        public void updateBillingAddress(User user) throws AdException{
        try{
        beginTransaction();
        getSession().update(user);
        commit();
        } catch (HibernateException e) {
               rollback();
               throw new AdException("Exception while creating user: " + e.getMessage());
           } 
        }
}
