package models.dao;

import models.interfaces.BookDAO;
import models.interfaces.OrderDAO;
import models.interfaces.ReaderDAO;
import models.mysql.MySqlBookDAO;
import models.mysql.MySqlOrderDAO;
import models.mysql.MySqlReaderDAO;

public class DAOFactory {
    public BookDAO getMySqlBookDAO(){
        return new MySqlBookDAO();
    }
    public OrderDAO getMySqlOrderDAO(){
        return new MySqlOrderDAO();
    }
    public ReaderDAO getMySqlReaderDAO(){
        return new MySqlReaderDAO();
    }
}
