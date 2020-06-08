package by.gstu.model.dao;

import by.gstu.model.interfaces.MySqlReaderDAO;
import by.gstu.model.mysql.MySqlReaderDAOImpl;

public class MySqlDAOFactory {
    public MySqlReaderDAO getMySqlReaderDAO(){
        return new MySqlReaderDAOImpl();
    }
}
