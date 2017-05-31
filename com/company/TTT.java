package com.company;

import com.company.ThreadImpl.TreadTweetImpl;
import com.company.dataModul.Tweet;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Алексей on 05.05.2017.
 */
public class TTT extends Thread  {
    private static final CountDownLatch latch = new CountDownLatch(3);
}
