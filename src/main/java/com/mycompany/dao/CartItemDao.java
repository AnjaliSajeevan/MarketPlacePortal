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
import com.mycompany.pojo.Category;
import com.mycompany.pojo.Product;
import com.mycompany.pojo.User;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

/**
 *
 * @author Anjali
 */
@Component
public class CartItemDao extends DAO{
    
           public CartItem getCartItem(Product product,Cart cart) throws AdException{
     try{
        beginTransaction();
        String hql = "FROM CartItem where product = :product and cart = :cart and orderid= :order";
        Query query = getSession().createQuery(hql);
        query.setParameter("product", product);
        query.setParameter("cart", cart);
        query.setParameter("order", 0);
        CartItem cartitem = (CartItem) query.uniqueResult();
        commit();
        return cartitem;
        } catch (HibernateException e) {
               rollback();
               throw new AdException("Exception while creating user: " + e.getMessage());
           } 
    }
           
        public boolean addCartItem(CartItem cartitem) throws AdException{
        boolean result=false;
        try{
        beginTransaction();
            getSession().save(cartitem);
            commit();
            result=true;
             return result;
        } catch (HibernateException e) {
               rollback();
               throw new AdException("Exception while creating cart: " + e.getMessage());
           } 
       
    }
              
               public void updateCartItem(CartItem cartitem) throws AdException{
        try{
        beginTransaction();
        Session s=getSession();
        s.clear();
        s.update(cartitem);
        s.update(cartitem);
        commit();
        } catch (HibernateException e) {
               rollback();
               throw new AdException("Exception while creating user: " + e.getMessage());
           } 
        }

    
    
     public List<CartItem> getCartItemList(Cart cart) throws AdException{
        try{
         beginTransaction();
         Criteria criteria = getSession().createCriteria(CartItem.class);
        criteria.add(Restrictions.eq("cart", cart));
        criteria.add(Restrictions.eq("orderid", 0));
        List<CartItem> list= criteria.list();
        commit();
        return list;
        } catch (HibernateException e) {
               rollback();
               throw new AdException("Exception while getting cart Item List: " + e.getMessage());
           } 
    }
     

}
