package com.company.analyzer;

import com.company.parseImpl.IParse;
import com.company.dataModul.Tweet;

import java.io.*;
import java.util.*;
import java.util.List;

/**
 * Created by Алексей on 26.03.2017.
 */
public class TweetAnalyzer {
    public List<Tweet> getListTweets() {
        return listTweets;
    }

    public void setListTweets(List<Tweet> listTweets) {
        this.listTweets = listTweets;
    }

    private List<Tweet> listTweets;
    private IParse<Tweet> parser;
    public TweetAnalyzer(IParse<Tweet> parser){

        listTweets = new ArrayList<>();
       // this.parser = parser;
        this.parser = parser ;

    }



    public void read() {
        try {
            String str = new String();
            FileInputStream fstream = new FileInputStream("D:/all_tweets.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String line = new String();
            while ((line = br.readLine()) != null) {
                //line = br.readLine();
                if (line == null) {
                    break;
                }
                else {

                    Tweet tweet = parser.parse(line);
                    if(tweet.getDate()==null)
                    {

                        listTweets.get(listTweets.size()-1).setText(listTweets.get(listTweets.size()-1).getText().concat(tweet.getText()));
                    }
                    listTweets.add(tweet);
                }
            }
        } catch (IOException e) {
            System.out.println("Error");
        }

    }



    }

