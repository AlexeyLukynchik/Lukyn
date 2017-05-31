package com.company.ThreadReport;

import com.company.analyzer.ReportAnalyzer;
import com.company.dataModul.Tweet;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Andrei on 03.05.2017.
 */
public class ThreadReport1 extends Thread {
    public ReportAnalyzer ra;
    private final CountDownLatch latch;
    public   String[] str;
    public static List<Tweet> ans;
    public  ThreadReport1(CountDownLatch l, ReportAnalyzer r,String[] s){

        latch =l;
        ra = r;
        str = s;
    }


    @Override
    public void run() {
        ThreadReport1.report(ra,str);
        latch.countDown();
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void report(ReportAnalyzer ra, String[] str) {
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



        ans = hash;
    }
}
