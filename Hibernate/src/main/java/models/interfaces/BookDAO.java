package models.interfaces;

import models.entities.Book;

import java.util.List;

public interface BookDAO {
    void add(Book book);
    void delete(Book book);
    void update(Book book);
    List<Book> getBooks();
    Book getBookByNameAndAuthor(String name, String author);
}
