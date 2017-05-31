package com.company.ThreadData;

import com.company.ThreadImpl.ThreadSentImpl;
import com.company.dataModul.Sentiment;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Andrei on 29.04.2017.
 */
public class ThreadSent extends Thread {

    private List<Sentiment> listSent;
    private final CountDownLatch latch;

    public List<Sentiment> getListSent() {
        return listSent;
    }

    public void setListSent(List<Sentiment> listSent) {
        this.listSent = listSent;
    }

   // private IParse<Sentiment> parser;
    public ThreadSent(CountDownLatch l)
                       {
  latch = l;
        listSent = new ArrayList<>();
      // this.parser = parser;

    }

    @Override
    public void run() {
        try {
            FileInputStream fstream = new FileInputStream("D:/sentiments.csv");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                if (strLine == null){
                    latch.countDown();
                    latch.await();
                    break;}
                else {
                    ThreadSentImpl TSI = new ThreadSentImpl(strLine);
                    TSI.run();

                    Sentiment sent = ThreadSentImpl.s;
                    listSent.add(sent);
                }

            }

        } catch (IOException e) {
            System.out.println("Error");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
