package com.cpifppiramide.animalitos.context;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDBConnection {

    private static Connection connection;

    private MySQLDBConnection(){}

    public static Connection getInstance() {
        if(connection == null) {
            try {
                connection = DriverManager.getConnection(
                        "jdbc:mysql://rdsservidor.cnawwwse41p7.us-east-1.rds.amazonaws.com:3306/Animalitos",
                        "admin", "#{(nano33)}");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }

}