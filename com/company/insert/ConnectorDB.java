package com.company.insert;

/**
 * Created by Andrei on 06.05.2017.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectorDB {
    public static Connection getConnection() throws SQLException {
        // URL к базе состоит из
        // протокола:подпротокола://[хоста]:[порта_СУБД]/[БД] и других_сведений
        String url = "jdbc:postgresql://localhost/Twitter";
        // Имя пользователя БД
        String name = "postgres";
        // Пароль
        String password = "qwedsazxc1";
        return DriverManager.getConnection(url, name, password);
    }
}
