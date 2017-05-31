package com.company.ThreadData;

import com.company.ThreadImpl.ThreadStateImpl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Andrei on 01.05.2017.
 */
public class ThreadState extends Thread {
    public List<com.company.dataModul.State> getListState1() {
        return listState1;
    }
    private final CountDownLatch latch;
    public void setListState1(List<com.company.dataModul.State> listState1) {
        this.listState1 = listState1;
    }

    private List<com.company.dataModul.State> listState1;
   // private IParse<com.company.dataModul.State> parser;
    public ThreadState(CountDownLatch l){
latch =l;
        listState1 = new ArrayList<>();
       // this.parser = parser;

    }

    @Override
    public void run() {
        try {


            BufferedReader reader = new BufferedReader(new FileReader("D:/states.json"));
      ThreadStateImpl TTSI = new ThreadStateImpl(reader.readLine());
            TTSI.run();
            listState1 = ThreadStateImpl.st;
            TTSI.interrupt();

            latch.countDown();
            latch.await();
            //listState1  = (List<com.company.dataModul.State>) parser.parse(reader.readLine());
            //listState.add(state);
        } catch (IOException e) {
            System.out.println("Error");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    }

