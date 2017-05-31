package com.company.ThreadData;

import com.company.ThreadImpl.TreadTweetImpl;
import com.company.dataModul.Tweet;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Andrei on 29.04.2017.
 */
public class ThreadTweet extends Thread {
    public List<Tweet> getListTweets() {
        return listTweets;
    }

    public void setListTweets(List<Tweet> listTweets) {
        this.listTweets = listTweets;
    }
   private final CountDownLatch latch;
    private List<Tweet> listTweets;
    /*private IParse<Tweet> parser;*/
    public ThreadTweet(CountDownLatch lat){
        latch = lat;
        listTweets = new ArrayList<>();
        // this.parser = parser;
        //this.parser = parser ;

    }
    @Override
    public void run() {
        try {
        String str = new String();
        FileInputStream fstream = new FileInputStream("D:/all_tweets.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        String line = new String();
        while ((line = br.readLine()) != null) {
            //line = br.readLine();
            if (line == null) {
                latch.countDown();
                latch.await();
                break;


            }
            else {

               // Tweet tweet = parser.parse(line);
                 TreadTweetImpl TTI = new TreadTweetImpl(line);
                //TTI.start();
                TTI.run();
                Tweet tweet =  TreadTweetImpl.t;
                TTI.interrupt();
                //System.out.println(tweet.getText());
                if(tweet.getDate()==null)
                {

                    listTweets.get(listTweets.size()-1).setText(listTweets.get(listTweets.size()-1).getText().concat(tweet.getText()));
                }
                listTweets.add(tweet);
            }
        }
    } catch (IOException e) {
        System.out.println("Error");
    } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    }
