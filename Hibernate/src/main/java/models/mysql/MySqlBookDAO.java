package models.mysql;

import models.dao.HibernateSessionFactoryUtil;
import models.entities.Book;
import models.entities.Order;
import models.entities.Reader;
import models.interfaces.BookDAO;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlBookDAO implements BookDAO {

    @Override
    public void add(Book book) {
        Session session = null;
        try{
            session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(book);
            session.getTransaction().commit();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при добавлении книги", JOptionPane.OK_OPTION);
        }finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
    }

    @Override
    public void delete(Book book) {
        Session session = null;
        try{
            session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(book);
            session.getTransaction().commit();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при удалении книги", JOptionPane.OK_OPTION);
        }finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
    }

    @Override
    public void delete(int id) {
        Session session = null;
        try{
            session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Book book = getBookById(id);
            session.delete(book);
            session.getTransaction().commit();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при удалении книги", JOptionPane.OK_OPTION);
        }
        finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
    }

    @Override
    public void update(Book book) {
        Session session = null;
        try{
            session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(book);
            session.getTransaction().commit();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при обновлении книги", JOptionPane.OK_OPTION);
        }finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
    }

    @Override
    public List<Book> getBooks() {
        Session session = null;
        List<Book> books = new ArrayList<Book>();
        try{
            session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            books = session.createCriteria(Book.class).list();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при выводе данных", JOptionPane.OK_OPTION);
        }finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return books;
    }

    @Override
    public Book getBookByNameAndAuthor(String name, String author) {
        Session session = null;
        Book findBook = null;
        try{
            session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("from Book where name =:name and author =:author");
            query.setParameter("name", name);
            query.setParameter("author", author);
            session.getTransaction().commit();
            findBook = (Book)query.uniqueResult();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при выводе данных", JOptionPane.OK_OPTION);
        }finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return findBook;
    }

    @Override
    public Book getBookById(int id) {
       Session session = null;
       Book findBook = null;
       try{
           session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
           session.beginTransaction();
           findBook = session.get(Book.class, id);
           session.getTransaction().commit();
       }catch (Exception e){
           JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при поиске книги", JOptionPane.OK_OPTION);
       }finally {
           if (session != null && session.isOpen()){
               session.close();
           }
       }
       return findBook;
    }
}
