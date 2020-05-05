package models.interfaces;

import models.entities.Book;

import java.util.Iterator;

public interface BookDAO {
    boolean add(Book book);
    boolean remove(Book book);
    boolean update(Book book);
    Iterator<Object> getAllBooks();
}
