package com.company.parseImpl;
import com.company.dataModul.Tweet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Алексей on 27.03.2017.
 */
public class TweetParseImpl implements IParse<Tweet> {
    @Override
    public Tweet parse(String str) {
String s = new String();
   List<Tweet> vrem = new ArrayList<>();
        Pattern p = Pattern.compile("\\[(\\-?[0-9]+\\.[0-9]+)\\,.(\\-?[0-9]+\\.[0-9]+)\\].([0-9]+).([0-9]{4}\\-[0-9]{2}\\-[0-9]{2}).([0-9]{2}:[0-9]{2}:[0-9]{2}).(.*)");
        SimpleDateFormat parserSDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d=null;
        Matcher m = p.matcher(str);
      //  s = m.group(6);
        if (m.find()){
            try {


                d = parserSDF.parse(m.group(4) + ' ' + m.group(5));
            }catch (ParseException e)
            {e.getStackTrace();}
                Tweet tweeter = new Tweet(d, m.group(6));
            Tweet.GeoCord geoC = tweeter.new GeoCord(Double.parseDouble(m.group(1)), Double.parseDouble(m.group(2)));
            tweeter.setCoord(geoC);

            return tweeter;
           } else {
            Tweet twet = new Tweet(null,s);
            Tweet.GeoCord gc = twet.new GeoCord(0.0,0.0);
            return twet;

        }




}}

