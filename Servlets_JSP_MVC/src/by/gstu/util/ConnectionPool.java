package by.gstu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConnectionPool {
    private static final String URL = "jdbc:mysql://localhost:3306/library?&serverTimezone=UTC";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "Mad_Riders1999";

    private static final int POOL_SIZE = 5; // pool size
    private static ConnectionPool instance;
    private BlockingQueue<Connection> connections;

    public synchronized static ConnectionPool getInstance() { //Singelton
        if (instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }

    private ConnectionPool(){
        connections = new ArrayBlockingQueue<>(POOL_SIZE);
        for (int i = 0; i < POOL_SIZE; i++){
            Connection connection = null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(URL,  USER_NAME, PASSWORD);
                connections.offer(connection);
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public Connection getConnection() throws InterruptedException {
        return connections.take();
    }

    public void closeConnection(Connection connection) {
        if (connection != null){
            connections.offer(connection);
        }
    }
}
