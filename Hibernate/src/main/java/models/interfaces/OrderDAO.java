package models.interfaces;

import models.entities.Book;
import models.entities.Order;
import models.entities.Reader;

import java.util.List;

public interface OrderDAO {
    void add(Order order);
    void delete(Order order);
    void delete(int id);
    List<Order> getorders();
    Order getOrderById(int id);
    List<Order> getOrdersByReader(Reader reader);
    List<Order> getOrdersByReaderId(int id);
}
