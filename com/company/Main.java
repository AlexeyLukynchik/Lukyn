package com.company;

import com.company.analyzer.ReportAnalyzer;
import com.company.analyzer.SentAnalyzer;
import com.company.analyzer.StateAnalyzer;
import com.company.analyzer.TweetAnalyzer;
import com.company.dataModul.State;
import com.company.dataModul.Tweet;
import com.company.parseImpl.SentParseImpl;
import com.company.parseImpl.StateParseImpl;
import com.company.parseImpl.TweetParseImpl;
import com.company.report.IReport;
import com.company.report.ReportOne;
import com.company.report.ReportThree;
import com.company.report.ReportTwo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
	// write your code here

        TweetAnalyzer tweet = new TweetAnalyzer(new TweetParseImpl());
        StateAnalyzer state = new StateAnalyzer(new StateParseImpl());
        SentAnalyzer sent = new SentAnalyzer(new SentParseImpl());
        //ArrayList<Tweet> h = tweet.read();
       // tw.read();
        tweet.read();
        //tweet.getListTweets();
        state.read();
        List<State> g = new ArrayList<>();
        //List<State> stateL = new HashSet<State>(state.getListState1());
     HashSet<State>  sr= new HashSet<State>(state.getListState1());
  for(State se:sr)
      g.add(se);

        sent.read();
        ReportAnalyzer RA = new ReportAnalyzer(tweet.getListTweets(),sent.getListSent(),g);
        String[] strH = new String[2];
        strH[0]= "fspiders";
        //ReportOne
       // IReport<List<Tweet>> RO = new ReportOne();
        //RO.report(RA,strH);
        strH[0] = "2011-08-28 19:00:00";
        strH[1] = "2011-09-04 19:00:00";
       // IReport<List<String>> tr = new ReportThree();
        ReportTwo rt = new ReportTwo();
        rt.report(RA,strH);
       // tr.report(RA,strH);
     //   ReportThree tr1 = new ReportThree();
      //  tr1.report(RA,strH);
        //for (Tweet tw:RA.tw) {
          //  System.out.println(tw.getDate().toString());

        //}

        }
    }

