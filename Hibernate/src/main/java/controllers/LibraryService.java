package controllers;

import models.entities.Book;
import models.entities.Order;
import models.entities.Reader;
import models.mysql.MySqlBookDAO;
import models.mysql.MySqlOrderDAO;
import models.mysql.MySqlReaderDAO;

import java.util.List;

public class LibraryService {
    private MySqlReaderDAO readerDAO;
    private MySqlBookDAO bookDAO;
    private MySqlOrderDAO orderDAO;

    public LibraryService(){
        this.readerDAO = new MySqlReaderDAO();
        this.bookDAO = new MySqlBookDAO();
        this.orderDAO = new MySqlOrderDAO();
    }

    public class BookService{

        public void addBook(Book book){
            bookDAO.add(book);
        }

        public void deleteBook(Book book){
            bookDAO.delete(book);
        }

        public void updateBook(Book book){
            bookDAO.update(book);
        }

        public List<Book> getBooks(){
            return bookDAO.getBooks();
        }

        public Book getBookByNameAndAuthor(String name, String author){
            return bookDAO.getBookByNameAndAuthor(name, author);
        }

        public Book getBookById(int id){return bookDAO.getBookById(id);}
    }

    public class ReaderService{

        public void addReader(Reader reader){
            readerDAO.add(reader);
        }

        public void deleteReader(Reader reader){
            readerDAO.delete(reader);
        }

        public void deleteReaderById(int id) {readerDAO.delete(id);}

        public void updateReader(Reader reader){
            readerDAO.update(reader);
        }

        public List<Reader> getReaders(){
            return readerDAO.getReaders();
        }

        public Reader getReader(Reader reader){
            return readerDAO.getReader(reader);
        }

        public Reader getReaderById(int id) {return  readerDAO.getReaderById(id);}
    }

    public class OrderService{

        public void addOrder(Order order){
            orderDAO.add(order);
        }

        public void deleteOrder(Order order){
            orderDAO.delete(order);
        }

        public Order getOrder(Order order) {return orderDAO.getOrder(order);}

        public List<Order> getOrders(){
            return orderDAO.getorders();
        }

        public List<Order> getOrder(Reader reader){
            return orderDAO.getOrdersByReader(reader);
        }
    }
}
