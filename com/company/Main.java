package com.company;

import com.company.ThreadData.ThreadSent;
import com.company.ThreadData.ThreadState;
import com.company.ThreadData.ThreadTweet;
import com.company.ThreadReport.ThreadReport3;
import com.company.analyzer.ReportAnalyzer;
import com.company.analyzer.SentAnalyzer;
import com.company.analyzer.StateAnalyzer;
import com.company.analyzer.TweetAnalyzer;
import com.company.dataModul.State;
import com.company.insert.InsertState;
import com.company.parseImpl.SentParseImpl;
import com.company.parseImpl.StateParseImpl;
import com.company.parseImpl.TweetParseImpl;
import com.company.report.ReportThree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Main {

    public static void main(String[] args) throws Exception {
	// write your code here

       /* TweetAnalyzer tweet = new TweetAnalyzer(new TweetParseImpl());
        StateAnalyzer state = new StateAnalyzer(new StateParseImpl());
        SentAnalyzer sent = new SentAnalyzer(new SentParseImpl());
        //ArrayList<Tweet> h = tweet.read();
       // tw.read();
        tweet.read();
        //tweet.getListTweets();
        state.read();
        sent.read();
        List<State> g = new ArrayList<>();
       // List<State> stateL = new HashSet<State>(state.getListState1());
     HashSet<State>  sr= new HashSet<State>(state.getListState1());
  for(State se:sr)
      g.add(se);

        //ThreadTweet yy = new ThreadTweet(new TweetParseImpl());
       /// sent.read();
        ReportAnalyzer RA = new ReportAnalyzer(tweet.getListTweets(),sent.getListSent(),g);
        String[] strH = new String[2];
      //  strH[0]= "fspiders";
        //ReportOne
       // IReport<List<Tweet>> RO = new ReportOne();
        //RO.report(RA,strH);
        strH[0] = "2011-08-28 19:00:00";
        strH[1] = "2011-09-04 19:00:00";

        // IReport<List<String>> tr = new ReportThree();
        //ReportTwo rt = new ReportTwo();
        //rt.report(RA,strH);
       // tr.report(RA,strH);
       ReportThree tr1 = new ReportThree();
        tr1.report(RA,strH);
        //for (Tweet tw:RA.tw) {
          //  System.out.println(tw.getDate().toString());

        //}*/
     //  TTT tt = new TTT();
       // tt.run();
        //START THREAD!!!!

        CountDownLatch latch = new CountDownLatch(3);
      // private static final CountDownLatch latch = new CountDownLatch(3);
  ThreadTweet tweets = new ThreadTweet(latch);
        //tweets.start();
        tweets.run();
        ThreadSent setns = new ThreadSent(latch);
       //System.out.println(latch.getCount());
        //setns.start();
        latch.countDown();
        setns.run();
        latch.countDown();
        ThreadState states = new ThreadState(latch);
        //latch.countDown();
        states.run();
latch.countDown();
        //states.start();

        List<State> g = new ArrayList<>();
        // List<State> stateL = new HashSet<State>(state.getListState1());
        HashSet<State> sr= new HashSet<State>(states.getListState1());
        for(State se:sr)
            g.add(se);

        String[] strH = new String[2];
        strH[0] = "2011-08-28 19:00:00";
        strH[1] = "2011-09-04 19:00:00";
        ReportAnalyzer RA = new ReportAnalyzer(tweets.getListTweets(),setns.getListSent(),g);
        CountDownLatch latch1 = new CountDownLatch(1);
        ThreadReport3 T3 = new ThreadReport3(latch1,RA,strH);
        latch1.countDown();
        T3.start();
  /* Connect.getConnection();
        try {
            Connect.createDbUserTable();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //tweets.interrupt();

/*
        String[] strH = new String[2];
        strH[0] = "2011-08-28 19:00:00";
        strH[1] = "2011-09-04 19:00:00";
        ReportAnalyzer RA = new ReportAnalyzer(tweets.getListTweets(),setns.getListSent(),g);
        CountDownLatch latch1 = new CountDownLatch(1);
//ThreadReport1 T1 = new ThreadReport1(latch1,RA,strH);
  //      ThreadReport2 T2 = new ThreadReport2(latch1,RA,strH);
        ThreadReport3 T3 = new ThreadReport3(latch1,RA,strH);
        latch1.countDown();
        T3.start();*/
       /* CountDownLatch latch = new CountDownLatch(3);
        // private static final CountDownLatch latch = new CountDownLatch(3);
        ThreadTweet tweets = new ThreadTweet(latch);
        //tweets.start();
        tweets.run();
        ThreadSent setns = new ThreadSent(latch);
        //System.out.println(latch.getCount());
        //setns.start();
        latch.countDown();
        setns.run();
        latch.countDown();
        ThreadState states = new ThreadState(latch);
        //latch.countDown();
        states.run();
        latch.countDown();
        //states.start();

        List<State> g = new ArrayList<>();
        // List<State> stateL = new HashSet<State>(state.getListState1());

        ReportAnalyzer RA = new ReportAnalyzer(tweets.getListTweets(),setns.getListSent(),g);
//Connect.getConnection(RA);
//InsertSent.getConnection(setns.getListSent());
//InsertState.getConnection(g);
  //SelectDate.selectSentiments();
      // SelectDate.selectStates();
    //SelectDate.selectTweets();
        HashSet<State> sr= new HashSet<State>(SelectDate.selectStates());
        for(State se:sr)
            g.add(se);
        ReportAnalyzer r = new ReportAnalyzer( SelectDate.selectTweets(),SelectDate.selectSentiments(),g);
        String[] strH = new String[2];
        strH[0] = "2011-08-28 19:00:00";
        strH[1] = "2011-09-04 19:00:00";
        ReportThree tr1 = new ReportThree();
        tr1.report(r,strH);
        */
       // MapStates mapUSA = new MapStates (SelectDate.selectStates());
      /*  TweetAnalyzer tweet = new TweetAnalyzer(new TweetParseImpl());
        StateAnalyzer state = new StateAnalyzer(new StateParseImpl());
        SentAnalyzer sent = new SentAnalyzer(new SentParseImpl());
        //ArrayList<Tweet> h = tweet.read();
        // tw.read();
        tweet.read();
        //tweet.getListTweets();
        state.read();
        sent.read();
        List<State> g = new ArrayList<>();
        // List<State> stateL = new HashSet<State>(state.getListState1());
        HashSet<State>  sr= new HashSet<State>(state.getListState1());
        for(State se:sr)
            g.add(se);
        ReportAnalyzer RA = new ReportAnalyzer(tweet.getListTweets(),sent.getListSent(),g);
        String[] strH = new String[2];
        //  strH[0]= "fspiders";
        //ReportOne
        // IReport<List<Tweet>> RO = new ReportOne();
        //RO.report(RA,strH);
        strH[0] = "2011-08-28 19:00:00";
        strH[1] = "2011-09-04 19:00:00";

        // IReport<List<String>> tr = new ReportThree();
        //ReportTwo rt = new ReportTwo();
        //rt.report(RA,strH);
        // tr.report(RA,strH);
        ReportThree tr1 = new ReportThree();
        tr1.report(RA,strH);
*/
    }
    }
