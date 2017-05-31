package com.company.insert;

import com.company.dataModul.State;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Created by Andrei on 11.05.2017.
 */
public class InsertState {
    public static void getConnection(List<State> stat) throws SQLException, ClassNotFoundException {

        // URL к базе состоит из
        // протокола:подпротокола://[хоста]:[порта_СУБД]/[БД] и других_сведений
        String url = "jdbc:postgresql://localhost/Twitter";
//		// Имя пользователя БД
        String name = "postgres";
//		// Пароль
        String password = "qwedsazxc1";
        Connection connection = null;
        try { // 1 блок
            // Загружаем драйвер
            Class.forName("org.postgresql.Driver");
            System.out.println("Драйвер подключен");
            // Создаём соединение
            //connection = DriverManager.getConnection(url, name, password);
            connection = ConnectorDB.getConnection();
            System.out.println("Соединение установлено");
            Statement st = connection.createStatement();
            try { String insertState = "INSERT INTO public.\"state\"(name,areas) values(?,?)";
                PreparedStatement psState = connection.prepareStatement(insertState);
                Integer i =0;
                for (State st1 : stat){
                    psState.setString(1,st1.getNameState());
                    psState.setObject(2, st1.areasToString());

                    psState.executeUpdate();
                    i++;
                }}
            finally {
				/*
				 * закрыть Statement, если он был открыт или ошибка произошла во
				 * время создания Statement
				 */
                /*if (st != null) { // для 2-го блока try
                    st.close();
                } else {
                    System.err.println("Statement не создан");
                }*/
            }
        } catch (SQLException | ClassNotFoundException e) { // для 1-го блока
            // try
            System.err.println("DB connection error: " + e);
			/*
			 * вывод сообщения о всех SQLException
			 */
        } finally {
			/*
			 * закрыть Connection, если он был открыт
			 */
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.err.println("Сonnection close error: " + e);
                }
            }
        }
    }
}
