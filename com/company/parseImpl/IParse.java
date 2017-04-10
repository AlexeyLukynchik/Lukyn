package com.company.parseImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;

/**
 * Created by Алексей on 26.03.2017.
 */
public interface IParse<T> {

//void read();
    T parse(String str);
// <T> void makeTweets(Matcher m, Date d);

}
