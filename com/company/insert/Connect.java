package com.company.insert;

/**
 * Created by Andrei on 30.04.2017.
 */
import com.company.analyzer.ReportAnalyzer;
import com.company.dataModul.Sentiment;
import com.company.dataModul.Tweet;
import com.company.insert.ConnectorDB;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Connect {
    //jdbc:mysql://127.0.0.1:3306/?user=root
  /*  private static final String URL = "jdbc:mysql://127.0.0.1:3306/twet";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String NAME = "root";
    private static final String PASSWORD = "qwedsazxc1;*/

    public static void getConnection(ReportAnalyzer reportAnalyzer) throws SQLException, ClassNotFoundException {

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
            try { // 2 блок
                // Для использования SQL запросов существуют 3 типа
                // объектов:
                // 1.Statement: используется для простых случаев без
                // параметров


                    // Выполним запрос
                   // rs = st.executeQuery("SELECT * FROM public.\"subscriber\"");
                   /*
                    while (rs.next()) {
                        int id = rs.getInt(1);
                        String lastName = rs.getString(2);
                        int phone = rs.getInt(3);


                    }
                    if (lst.size() > 0) {
                        System.out.println(lst);
                    } else {
                        System.out.println("Not found");
                    }*/

                    // Вставить запись
                SimpleDateFormat parserSDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                java.util.Date d=null;


                d = parserSDF.parse("2017-05-06 12:00:00");
                Timestamp timestamp = new Timestamp(d.getTime());
                String insert = "INSERT INTO public.\"tweet\"(lang,long,date,text) values(?,?,?,?)";
                PreparedStatement ps = connection.prepareStatement(insert);
              /*  ps.setDouble(1,56.8);
                ps.setDouble(2,56.8);
                ps.setTimestamp(3, timestamp);
                ps.setString(4,"gfggf");
                ps.executeUpdate();*/
                for(Tweet te:reportAnalyzer.tw)
                {
                    if(te.getDate() == null|| te.getText() == null){break;}
                    Timestamp timestamp1 = new Timestamp(te.getDate().getTime());
                    ps.setDouble(1,te.getCoord().getLatitude());
                    ps.setDouble(2,te.getCoord().getLongitude());
                    ps.setTimestamp(3, timestamp1);
                    ps.setString(4,te.getText());
                    ps.executeUpdate();

                }


                    // Обновить запись
//					st.executeUpdate(
//					 "UPDATE public.\"subscriber\" SET last_name = 'Sidorov' where id = 4");


            } catch (ParseException e) {
                e.printStackTrace();
            } finally {
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
