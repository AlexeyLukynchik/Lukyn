package com.company.analyzer;

import com.company.dataModul.Sentiment;
import com.company.dataModul.State;
import com.company.dataModul.Tweet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Алексей on 03.04.2017.
 */
public class ReportAnalyzer {

    public ArrayList<Tweet> tw;
    public ArrayList<Sentiment> sent;
    public ArrayList<State> stat;


    public ReportAnalyzer(List<Tweet> listTweets, List<Sentiment> listSent, List<State> listState1) {
        this.tw = (ArrayList<Tweet>) listTweets;
        this.sent = (ArrayList<Sentiment>) listSent;
        this.stat = (ArrayList<State>) listState1;
    }
}
