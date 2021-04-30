/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.pojo.Address;
import com.mycompany.pojo.User;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import com.mycompany.exceptionHandling.AdException;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

/**
 *
 * @author Anjali
 */
@Component
public class UserDao extends DAO {
    
    public boolean addUser(User user) throws AdException{
       boolean result=false;
        try{
            beginTransaction();
            
            getSession().save(user);
            commit();
            result=true;
            return result;
            
        } catch (HibernateException e) {
               rollback();
               throw new AdException("Exception while creating user: " + e.getMessage());
           } 
    }
    

    public User getUser(String email) throws AdException{
        try {
            beginTransaction();
            Query q = getSession().createQuery("from User where email = :email");
            q.setString("email", email);
            User user = (User) q.uniqueResult();
            commit();
            return user;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not get user " + email, e);
        }
    }
    
     public void updateUser(User user) throws AdException{
        try{
        beginTransaction();
        getSession().update(user);
        commit();
        } catch (HibernateException e) {
               rollback();
               throw new AdException("Exception while creating user: " + e.getMessage());
           } 
        }
     
    
    
     public Address getBillAddress(User user) throws AdException{
       try{ 
        beginTransaction();
        Criteria criteria = getSession().createCriteria(Address.class);
        criteria.add(Restrictions.eq("user", user));
        Address address = (Address) criteria.add(Restrictions.eq("billing","true"));
        commit();
        return address;}
       catch (HibernateException e) {
               rollback();
               throw new AdException("Exception while creating user: " +e.getMessage() );
           }
    }
     
      public List<Address> getCustAddress(User user) throws AdException{
        try{
            beginTransaction();
        Criteria criteria = getSession().createCriteria(Address.class);
        criteria.add(Restrictions.eq("user", user));
        criteria.add(Restrictions.eq("shipping","true"));
        List<Address> list= criteria.list();
        commit();
        return list;}
        catch (HibernateException e) {
               rollback();
               throw new AdException("Exception while creating user: " +e.getMessage() );
           }
    }
    
    public User checkEmail(String email) throws AdException{

        try{
            beginTransaction();
        Criteria criteria = getSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("email", email));
        User user= (User) criteria.uniqueResult();
        commit();
        return user;}
       catch (HibernateException e) {
               rollback();
               throw new AdException("Exception while creating user: " +e.getMessage() );
           }
    }
    
    public User loginCheck(String email,String password) throws AdException{
       try{ 
           beginTransaction();
        Criteria criteria = getSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("email", email));
        criteria.add(Restrictions.eq("password", password));
        User user= (User) criteria.uniqueResult();
        commit();
        return user;}
       catch (HibernateException e) {
               rollback();
               throw new AdException("Exception while creating user: " +e.getMessage() );
           }
}
}
