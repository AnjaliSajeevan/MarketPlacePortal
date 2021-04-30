/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import static com.mycompany.dao.DAO.getSession;
import com.mycompany.exceptionHandling.AdException;
import com.mycompany.pojo.Cart;
import com.mycompany.pojo.Orders;
import com.mycompany.pojo.Product;
import com.mycompany.pojo.User;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

/**
 *
 * @author Anjali
 */
@Component
public class OrdersDao extends DAO {

    public void addOrder(Orders order) throws AdException {
        try {
            beginTransaction();
            getSession().save(order);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Exception while adding order: " + e.getMessage());
        }

    }

    public void updateOrder(Orders order) throws AdException {
        try {
            beginTransaction();
            getSession().update(order);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Exception while creating user: " + e.getMessage());
        }
    }

    public List<Orders> getOrdersList() throws AdException {
        try {
            beginTransaction();
            Query q = getSession().createQuery("from Orders");
            List<Orders> list = q.list();
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not list the categories", e);
        }
    }

    public List<Orders> getOrdersListUser(User user) throws AdException {
        try {
            beginTransaction();
            Criteria criteria = getSession().createCriteria(Orders.class);
            criteria.add(Restrictions.eq("user", user));
            List<Orders> list = criteria.list();
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Exception while getting cart Item List: " + e.getMessage());
        }
    }

    public Orders getEachOrder(int id) throws AdException {
        try {
            beginTransaction();
            Orders order = getSession().get(Orders.class, id);
            commit();
            return order;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Exception while creating user: " + e.getMessage());
        }
    }
}
