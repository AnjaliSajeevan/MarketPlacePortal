/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import static com.mycompany.dao.DAO.getSession;
import com.mycompany.exceptionHandling.AdException;
import com.mycompany.pojo.Cart;
import com.mycompany.pojo.CartItem;
import com.mycompany.pojo.Category;
import com.mycompany.pojo.OrderItem;
import com.mycompany.pojo.Orders;
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
public class OrderItemDao extends DAO {

    public boolean addOrderItem(OrderItem orderItem) throws AdException {
        boolean result = false;
        try {
            beginTransaction();

            getSession().save(orderItem);
            commit();
            result = true;
            return result;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Exception while creating user: " + e.getMessage());
        }

    }

    public List<OrderItem> getOrderItemList(Orders order) throws AdException {
        try {
            beginTransaction();
            String hql = "FROM OrderItem where orders = : order";
            Query query = getSession().createQuery(hql);
            query.setParameter("order", order);
            List<OrderItem> result = query.list();
            commit();
            return result;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Exception while getting order item list: " + e.getMessage());
        }
    }

    public List<OrderItem> getOrderItemListAll() throws AdException {
        try {
            beginTransaction();
            String hql = "FROM OrderItem";
            Query query = getSession().createQuery(hql);
            List result = query.list();
            commit();
            return result;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Exception while creating user: " + e.getMessage());
        }
    }
    
    public List<OrderItem> getOrderItemListUser(Orders order,User user) throws AdException {
        try {
            beginTransaction();
            String hql = "FROM OrderItem where orders = : order and user = :user";
            Query query = getSession().createQuery(hql);
            query.setParameter("order", order);
            query.setParameter("order", order);
            List<OrderItem> result = query.list();
            commit();
            return result;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Exception while getting order item list: " + e.getMessage());
        }
    }
    
     public OrderItem getEachOrderItem(int id) throws AdException{
       try{
        beginTransaction();
        OrderItem orderItem = getSession().get(OrderItem.class, id);
        commit();
        return orderItem;
        } catch (HibernateException e) {
               rollback();
               throw new AdException("Exception while creating user: " + e.getMessage());
           } 
    }
     
     
      public void updateOrderItem(OrderItem orderItem) throws AdException {
        try {
            beginTransaction();
            getSession().update(orderItem);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Exception while creating user: " + e.getMessage());
        }
    }
}
