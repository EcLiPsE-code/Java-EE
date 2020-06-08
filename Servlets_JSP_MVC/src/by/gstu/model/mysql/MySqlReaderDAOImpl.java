package by.gstu.model.mysql;

import by.gstu.model.enities.Reader;
import by.gstu.model.interfaces.MySqlReaderDAO;

import by.gstu.util.ConfigurateManager;
import by.gstu.util.ConnectionPool;
import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlReaderDAOImpl implements MySqlReaderDAO {

    private static final String PRINT_ALL;
    private static final String REMOVE;
    private static final String UPDATE;
    private static final Logger logger = Logger.getLogger(MySqlReaderDAOImpl.class);
    static {
        ConfigurateManager configurateManager = ConfigurateManager.getInstance();
        PRINT_ALL = configurateManager.getProperty("readAll");
        REMOVE = configurateManager.getProperty("remove");
        UPDATE = configurateManager.getProperty("update");
    }

    @Override
    public List<Reader> getAllReaders() {
        List<Reader> listBooks = new ArrayList<Reader>();
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        try {
            connection = connectionPool.getConnection();
            preparedStatement = connection.prepareStatement(PRINT_ALL);

            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String lastName = resultSet.getString("lastName");
                int age = resultSet.getInt("age");
                listBooks.add(new Reader(id, name, surname, lastName, age));
            }
            return listBooks;
        } catch (SQLException | InterruptedException e) {
            logger.error(e.getMessage(), e);
        } finally {
            connectionPool.closeConnection(connection);
        }
        return null;
    }

    @Override
    public void deleteReaderById(int id) {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        try {
            connection = connectionPool.getConnection();
            preparedStatement = connection.prepareStatement(REMOVE);

            preparedStatement.setInt(1, id);
            logger.info("Читатель удален");
            preparedStatement.executeUpdate();
        } catch (SQLException | InterruptedException e) {
            logger.error(e.getMessage(), e);
        }
        finally {
            connectionPool.closeConnection(connection);
        }
    }

    @Override
    public void updateReaderById(int id) {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        ConnectionPool connectionPool = ConnectionPool.getInstance();

        try {
            connection = connectionPool.getConnection();
            preparedStatement = connection.prepareStatement(UPDATE);

            preparedStatement.setInt(1, id);
            logger.info("Данные о читателе успешно обновлены");
            preparedStatement.executeUpdate();
        } catch (SQLException | InterruptedException e) {
            logger.error(e.getMessage(), e);
        } finally {
            connectionPool.closeConnection(connection);
        }
    }
}
