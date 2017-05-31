package com.company;

import com.company.analyzer.StateAnalyzer;
import com.company.dataModul.Sentiment;
import com.company.dataModul.State;
import com.company.dataModul.Tweet;
import com.company.insert.ConnectorDB;
import com.company.parseImpl.StateParseImpl;
import com.mysql.jdbc.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Andrei on 18.05.2017.
 */
public class SelectDate {
    public static List<Sentiment> selectSentiments() throws SQLException, ClassNotFoundException {
        List<Sentiment> sentiments = new ArrayList<>();
       // Connection connection = (Connection) ConnectorDB.getConnection();
        java.sql.Connection connection1 = ConnectorDB.getConnection();
        Statement statement = connection1.createStatement(); // РѕС‚РїСЂР°РІРєР° Р·Р°РїСЂРѕСЃР° РЅР° РїРѕР»СѓС‡РµРЅРёРµ
        String query = "SELECT * FROM sent";
        ResultSet resultSet = statement.executeQuery(query); // РїРѕР»СѓС‡РµРЅРёРµ РґР°РЅРЅС‹С…
        while (resultSet.next()){
            String text = resultSet.getString("val");
            float number = resultSet.getFloat("wei");
            Sentiment sentiment = new Sentiment(text,number);
            sentiments.add(sentiment);
        }

        statement.close();
        resultSet.close();
        connection1.close();
        return sentiments;
    }

    public static List<State> selectStates() throws SQLException, ClassNotFoundException {
        List<State> states = new ArrayList<>();
        java.sql.Connection connection1 = ConnectorDB.getConnection();
        Statement statement = connection1.createStatement();
        String text = "SELECT * FROM state";
        ResultSet resultSet = statement.executeQuery(text);

        while(resultSet.next()){
            String nameState = resultSet.getString("name");
            String coordinates = resultSet.getString("areas");
            StateAnalyzer state = new StateAnalyzer(new StateParseImpl());
            state.read();
            states = state.getListState1();
        }
        connection1.close();
        statement.close();
        resultSet.close();
        return states;
    }
    public static List<Tweet> selectTweets() throws SQLException, ClassNotFoundException {
        List<Tweet> tweetList = new ArrayList<>();
        java.sql.Connection connection1 = ConnectorDB.getConnection();
        Statement statement = connection1.createStatement();
        String query = "SELECT * FROM tweet";
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()){
             Double lat =resultSet.getDouble("lang");
             Double lon =resultSet.getDouble("long");

            Date date = resultSet.getTimestamp("date");
            String text = resultSet.getString("text");
            Tweet tweeter = new Tweet(date, text);
            Tweet.GeoCord geoC = tweeter.new GeoCord(lat, lon);
            tweeter.setCoord(geoC);

            tweetList.add(tweeter);
        }
        connection1.close();
        statement.close();
        resultSet.close();
        return tweetList;
    }



}
