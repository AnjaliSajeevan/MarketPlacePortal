/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import static com.mycompany.dao.DAO.getSession;
import com.mycompany.exceptionHandling.AdException;
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
public class ProductDao extends DAO {
        
    public boolean addProduct(Product product) throws AdException{
        boolean result=false;
        try{
        beginTransaction();
            getSession().save(product);
            commit();
            result=true;
             return result;
        } catch (HibernateException e) {
               rollback();
               throw new AdException("Exception while creating user: " + e.getMessage());
           } 
       
    }
    
    public Product getEachProduct(int id) throws AdException{
       try{
        beginTransaction();
        Product product = getSession().get(Product.class, id);
        commit();
        return product;
    } catch (HibernateException e) {
               rollback();
               throw new AdException("Exception while creating user: " + e.getMessage());
           } 
    }
    
     public List<Product> getProductList() throws AdException{
        try{
        beginTransaction();
        String hql="FROM Product";
        Query query=getSession().createQuery(hql);
        List result = query.list();
        commit();
        return result;
        } catch (HibernateException e) {
               rollback();
               throw new AdException("Exception while creating user: " + e.getMessage());
           } 
    }
     
     public List<Product> getUserProductList(User user) throws AdException{
        try{
        beginTransaction();
        String hql = "FROM Product where user = : user";
        Query query = getSession().createQuery(hql);
        query.setParameter("user", user);
        List<Product> productList = query.list();
        commit();
        return productList;
        } catch (HibernateException e) {
               rollback();
               throw new AdException("Exception while creating user: " + e.getMessage());
           } 
    }
    
    public List<Product> searchproduct(int id) throws AdException {
        try{
        beginTransaction();
        
        String hql = "FROM Product where categoryid = :id";
        Query query = getSession().createQuery(hql);
        query.setParameter("id", id);
        List<Product> results = query.list();
        commit();
        return results;
        } catch (HibernateException e) {
               rollback();
               throw new AdException("Exception while creating categoryid: " + e.getMessage());
           } 
        }
    
     public void  updateproduct(Product product) throws AdException {
        try{
        beginTransaction();
        getSession().update(product);
        commit();
        } catch (HibernateException e) {
               rollback();
               throw new AdException("Exception while creating user: " + e.getMessage());
           } 
        }
     
  
    public void delete(Product product) throws AdException {
        try {
           beginTransaction();
            getSession().delete(product);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not delete user " + product.getName(), e);
        }
}
    public List<Product> autoSearch(int id) throws AdException {
        try {
            beginTransaction();
            String hql = "FROM Product where categoryid = :id";
            Query query = getSession().createQuery(hql);
            query.setParameter("id", id);
            List<Product> results = query.list();
            commit();
            return results;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not autosearch user " + id, e);
        }
    }

}
