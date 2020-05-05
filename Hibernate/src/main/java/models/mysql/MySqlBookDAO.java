package models.mysql;

import models.entities.Book;
import models.interfaces.BookDAO;

import java.util.Iterator;

public class MySqlBookDAO implements BookDAO {
    @Override
    public boolean add(Book book) {
        return false;
    }

    @Override
    public boolean remove(Book book) {
        return false;
    }

    @Override
    public boolean update(Book book) {
        return false;
    }

    @Override
    public Iterator<Object> getAllBooks() {
        return null;
    }
}
