package com.company.ThreadImpl;

import com.company.dataModul.Sentiment;

/**
 * Created by Andrei on 01.05.2017.
 */
public class ThreadSentImpl extends Thread
{
   public static  Sentiment s;
    public String getStrr() {
        return strr;
    }

    public void setStrr(String strr) {
        this.strr = strr;
    }

    private String strr;
    public ThreadSentImpl(String strt){
strr =strt;
    }

    @Override
    public void run() {
        ThreadSentImpl.parse(getStrr());

    }

    public static void parse(String str) {


        String[] temp = str.trim().split(",");





        String   se = temp[0].substring(0,temp[0].length());

        Sentiment sentimen = new Sentiment(se, Float.parseFloat(temp[1]));
        ThreadSentImpl.s = sentimen;

    }
}
