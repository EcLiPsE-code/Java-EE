package models.mysql;

import models.dao.HibernateSessionFactoryUtil;
import models.entities.Order;
import models.entities.Reader;
import models.interfaces.OrderDAO;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlOrderDAO implements OrderDAO {

    @Override
    public void add(Order order) {
        Session session = null;
        try{
            session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(order);
            session.getTransaction().commit();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при добавлении заказа", JOptionPane.OK_OPTION);
        }
        finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }
    }

    @Override
    public void delete(Order order) {
        Session session = null;
        try{
            session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            session.getTransaction();
            session.delete(order);
            session.getTransaction().commit();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при удалении данных", JOptionPane.OK_OPTION);
        }
        finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
    }

    @Override
    public List<Order> getorders() {
        Session session = null;
        List<Order> orders = new ArrayList<Order>();
        try{
            session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            orders = session.createCriteria(Order.class).list();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при выводе данных", JOptionPane.OK_OPTION);
        }
        return orders;
    }

    public Order getOrder(Order order){
        Session session = null;
        Order findOrder = null;
        try{
            session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("from Order where dateOfIssue =:dateOfIssue and countDay =:countDay" +
                    "and dateOfCompletion =:dateOfCompletion and typeOfIssue =:typeOfIssue and readerId =:readerId");
            query.setParameter("dateOfIssue", order.getDateOfIssue());
            query.setParameter("countDay", order.getCountDay());
            query.setParameter("dateOfCompletion", order.getDateOfCompletion());
            query.setParameter("typeOfIssue", order.getTypeOfIssue());
            query.setParameter("readerId", order.getReader().getId());
            session.getTransaction().commit();
            findOrder = (Order) query.uniqueResult();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при выводе данных", JOptionPane.OK_OPTION);
        }
        return findOrder;
    }

    @Override
    public List<Order> getOrdersByReader(Reader reader) {
         Session session = null;
         List<Order> findOrders = new ArrayList<Order>();
         try{
             session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
             session.beginTransaction();
             Query query = session.createQuery("from Order where readerId =:readerId");
             query.setParameter("readerId", reader.getId());
             session.getTransaction().commit();
             Hibernate.initialize(query.list());
             findOrders = query.list();
         }catch (Exception e){
             JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при выводе данных", JOptionPane.OK_OPTION);
         }
         return findOrders;
    }
}
