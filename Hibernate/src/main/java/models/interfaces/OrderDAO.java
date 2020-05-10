package models.interfaces;

import models.entities.Book;
import models.entities.Order;
import models.entities.Reader;

import java.util.List;

public interface OrderDAO {
    void add(Order order);
    void delete(Order order);
    List<Order> getorders();
    List<Order> getOrdersByReader(Reader reader);
}
