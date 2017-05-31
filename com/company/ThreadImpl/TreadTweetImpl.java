package com.company.ThreadImpl;

import com.company.dataModul.Tweet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Andrei on 29.04.2017.
 */
public class TreadTweetImpl extends Thread
{
    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }



    public static Tweet t;
    private String  str;

    public TreadTweetImpl(String str1){
        str = str1;

    }
    @Override
    public void run() {

       TreadTweetImpl.parset(getStr());

    }
    public static void parset (String str2){
        String s = new String();
        List<Tweet> vrem = new ArrayList<>();
        Pattern p = Pattern.compile("\\[(\\-?[0-9]+\\.[0-9]+)\\,.(\\-?[0-9]+\\.[0-9]+)\\].([0-9]+).([0-9]{4}\\-[0-9]{2}\\-[0-9]{2}).([0-9]{2}:[0-9]{2}:[0-9]{2}).(.*)");
        SimpleDateFormat parserSDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d=null;
        Matcher m = p.matcher(str2);
        //  s = m.group(6);
        if (m.find()){
            try {


                d = parserSDF.parse(m.group(4) + ' ' + m.group(5));
            }catch (ParseException e)
            {e.getStackTrace();}
            Tweet tweeter = new Tweet(d, m.group(6));
            Tweet.GeoCord geoC = tweeter.new GeoCord(Double.parseDouble(m.group(1)), Double.parseDouble(m.group(2)));
            tweeter.setCoord(geoC);
            TreadTweetImpl.t = tweeter;
           // return tweeter;
        } else {
            Tweet twet = new Tweet(null,s);
            Tweet.GeoCord gc = twet.new GeoCord(0.0,0.0);
            TreadTweetImpl.t = twet;
           // return twet;

        }




    }
    }
