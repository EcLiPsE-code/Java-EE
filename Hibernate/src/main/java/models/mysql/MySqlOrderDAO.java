package models.mysql;

import models.entities.Book;
import models.entities.Order;
import models.entities.Reader;
import models.interfaces.OrderDAO;

import java.util.Iterator;

public class MySqlOrderDAO implements OrderDAO {

    @Override
    public boolean createOrder(Order order) {
        return false;
    }

    @Override
    public boolean removeOrder(Book book, Reader reader) {
        return false;
    }

    @Override
    public Iterator<Object> getOrdersCurrentReader(Reader reader) {
        return null;
    }

    @Override
    public Iterator<Object> getAllOrders() {
        return null;
    }
}
