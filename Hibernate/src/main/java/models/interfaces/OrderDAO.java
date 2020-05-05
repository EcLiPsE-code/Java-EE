package models.interfaces;

import models.entities.Book;
import models.entities.Order;
import models.entities.Reader;

import java.util.Iterator;

public interface OrderDAO {
    boolean createOrder(Order order);
    boolean removeOrder(Book book, Reader reader);
    Iterator<Object> getOrdersCurrentReader(Reader reader);
    Iterator<Object> getAllOrders();
}
