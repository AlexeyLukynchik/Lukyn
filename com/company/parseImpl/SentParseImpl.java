package com.company.parseImpl;

import com.company.dataModul.Sentiment;

/**
 * Created by Andrei on 27.03.2017.
 */
public class SentParseImpl implements IParse<Sentiment> {
    @Override
    public Sentiment parse(String str) {


            String[] temp = str.trim().split(",");





          String   se = temp[0].substring(0,temp[0].length());

            Sentiment sentimen = new Sentiment(se, Float.parseFloat(temp[1]));
        return sentimen;

    }
}
