package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private ConnectionFactory(){
        throw new UnsupportedOperationException();
    }

    public static Connection getConnection(){
        Connection connection = null;

        String connectionUrl = "jdbc:sqlite::resource:banco.db";

        try {
            connection = DriverManager.getConnection(connectionUrl);
        } catch (SQLException e) {
            System.out.println("FALHA ao tentar criar conexão");
            throw new RuntimeException(e);
        }

        return connection;
    }
}
