/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import static com.mycompany.dao.DAO.getSession;
import com.mycompany.exceptionHandling.AdException;
import com.mycompany.pojo.Category;
import com.mycompany.pojo.Product;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

/**
 *
 * @author Anjali
 */
@Component
public class CategoryDao extends DAO {
  
    
    public boolean addDepartment(Category category) throws AdException{
        boolean result=false;
        try{
            beginTransaction();
            
            getSession().save(category);
             commit();
            result=true;
            return result;
        } catch (HibernateException e) {
               rollback();
               throw new AdException("Exception while creating user: " + e.getMessage());
           } 
      
    }
    
    public Category getEachDepartment(int id) throws AdException{
       try{
        beginTransaction();
        Category category = getSession().get(Category.class, id);
        commit();
        return category;
        } catch (HibernateException e) {
               rollback();
               throw new AdException("Exception while creating user: " + e.getMessage());
           } 
    }
    
     public List<Category> getDepartmentList() throws AdException{
        try{
         beginTransaction();
        String hql="FROM Category";
        Query query=getSession().createQuery(hql);
        List result = query.list();
        commit();
        return result;
        } catch (HibernateException e) {
               rollback();
               throw new AdException("Exception while creating user: " + e.getMessage());
           } 
    }
       public void delete(Category category) throws AdException {
        try {
           beginTransaction();
            getSession().delete(category);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not delete category " + category.getName(), e);
        }
}
       
          public void  updateDepartment(Category category) throws AdException {
        try{
        beginTransaction();
        getSession().update(category);
        commit();
        } catch (HibernateException e) {
               rollback();
               throw new AdException("Exception while creating user: " + e.getMessage());
           } 
        }
}
