package models.mysql;

import models.dao.HibernateSessionFactoryUtil;
import models.entities.Reader;
import models.interfaces.ReaderDAO;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlReaderDAO implements ReaderDAO {

    @Override
    public void add(Reader reader) {
        Session session = null;
        try{
            session  = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(reader);
            session.getTransaction().commit();

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке", JOptionPane.OK_OPTION);
        }finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
    }

    @Override
    public void delete(Reader reader) {
        Session session = null;
        try{
            session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(reader);
            session.getTransaction().commit();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при удалении", JOptionPane.OK_OPTION);
        }finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
    }

    @Override
    public void update(Reader reader) {
        Session session = null;
        try{
            session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(reader);
            session.getTransaction().commit();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при обновлении данных", JOptionPane.OK_OPTION);
        }finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
    }

    @Override
    public List<Reader> getReaders() {
        Session session = null;
        List<Reader> readers = new ArrayList<Reader>();
        try{
            session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            readers = session.createCriteria(Reader.class).list();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при выводе данных", JOptionPane.OK_OPTION);
        }finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return readers;
    }

    @Override
    public Reader getReader(Reader reader) {
        Session session = null;
        Reader findReader = null;
        try{
            session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            session.beginTransaction();
            String name = reader.getName();
            String surname = reader.getSurname();
            String lastName = reader.getLastName();
            int age = reader.getAge();
            Query query = session.createQuery("from Reader where name =:name and " +
                    "surname =:surname and lastName =:lastName and age =:age");
            query.setParameter("name", name);
            query.setParameter("surname", surname);
            query.setParameter("lastName", lastName);
            query.setParameter("age", age);
            session.getTransaction().commit();
            findReader = (Reader)query.uniqueResult();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при поиске читателя", JOptionPane.OK_OPTION);
        }finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return findReader;
    }
}
