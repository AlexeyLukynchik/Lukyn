package com.company.insert;

import com.company.dataModul.Sentiment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Created by Andrei on 11.05.2017.
 */
public class InsertSent {
    public static void getConnection(List<Sentiment> sen) throws SQLException, ClassNotFoundException {

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
            try { String insertSent = "INSERT INTO public.\"sent\"(val,wei) values(?,?)";
                PreparedStatement psSent = connection.prepareStatement(insertSent);
                for (Sentiment se : sen){

                    psSent.setString(1,se.getValue());
                    psSent.setDouble(2,se.getWeight());
                    psSent.executeUpdate();
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
            }}
