package com.company.report;

import com.company.analyzer.ReportAnalyzer;
import com.company.dataModul.Tweet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrei on 03.04.2017.
 * Determine all the tweets containing the specified hashtag
 */


public class ReportOne implements IReport<List<Tweet>> {
    /**
     * Override method for searching tweets
     * @param ra Class object containing tweets, states, emotional weight


     * @param str Array containing the required data

     *
     * @return Tweet with hashtag
     */


    @Override
    public List<Tweet> report(ReportAnalyzer ra, String[] str) {
        String symbol = "#";
        String hashtag = str[0];
        hashtag = symbol.concat(hashtag);
        //Integer countTweets = 0;
        List<Tweet> hash = new ArrayList<>();
        for(int i = 0;i<ra.tw.size();i++){
            if(ra.tw.get(i).getText().indexOf(hashtag)!= -1){
                hash.add(ra.tw.get(i));
                System.out.println(ra.tw.get(i).getText());
            }


        }



        return hash;
    }
}





