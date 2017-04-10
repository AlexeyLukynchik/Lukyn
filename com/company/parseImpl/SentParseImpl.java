package com.company.parseImpl;

import com.company.dataModul.Sentiment;

/**
 * Created by Алексей on 27.03.2017.
 */
public class SentParseImpl implements IParse<Sentiment> {
    @Override
    public Sentiment parse(String str) {


            String[] temp = str.trim().split(",");
        String se = "";
        char zap = ',';

        for(int i =0;i<temp[0].length();i++){
                 if(temp[0].charAt(i) != zap)
                     se+=temp[0].charAt(i);

             }
             se = temp[0].substring(temp[0].length());

            Sentiment sentimen = new Sentiment(se, Float.parseFloat(temp[1]));
        return sentimen;

    }
}
