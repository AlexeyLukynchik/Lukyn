package com.company.ThreadReport;

import com.company.analyzer.ReportAnalyzer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Andrei on 03.05.2017.
 */
public class ThreadReport2 extends Thread {

   public static List<Double> ans;
    public ReportAnalyzer ra;
    private final CountDownLatch latch;
   public String[] str;
    public  ThreadReport2(CountDownLatch l, ReportAnalyzer r,String[] s){

        latch =l;
        ra = r;
        str = s;
    }
    @Override
    public void run() {
        try {
            ThreadReport2.report(ra,str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        latch.countDown();
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void report(ReportAnalyzer ra, String[] str) throws Exception {

        String y = str[0];

        String y1 = str[1];
        List<Double> answer = new ArrayList<>();
        String zap = ",";
        Double emotionalWeight = 0.0;
        Date startTime = new Date();
        Date finishTime = new Date();
        String f = new String();
        for (int i =0;i<ra.tw.size();i++) {
            f = ra.tw.get(i).getText().toLowerCase();
            String temp[] =  f.split(" ");//ra.tw.get(i).getText().split(" ");
            emotionalWeight = 0.0;
            SimpleDateFormat parserSDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {

                startTime = parserSDF.parse(y);
                finishTime = parserSDF.parse(y1);


            } catch (Exception e) {
            }
            ;


            try {
                if (startTime.before(ra.tw.get(i).getDate()) && finishTime.after(ra.tw.get(i).getDate())) {

                    for (int ii = 0; ii < ra.sent.size(); ii++) {
                        // zap = ra.sent.get(ii).getValue().toLowerCase().concat(zap);
                        for (int j = 0; j < temp.length; j++)
                            if(ra.sent.get(ii).getValue().toLowerCase().compareTo(temp[j]) == 0)
                            //if (temp[j] == ra.sent.get(ii).getValue().toLowerCase())
                            {
                                emotionalWeight = emotionalWeight + ra.sent.get(ii).getWeight();
                                if (ra.sent.get(ii).getWeight() == null) {

                                    emotionalWeight = emotionalWeight + 0;
                                } //else {
                                //emotionalWeight = emotionalWeight + ra.sent.get(ii).getWeight();
                                //}

                            }
                    }
                    System.out.println(emotionalWeight);
                }
            } catch ( Exception e){
                emotionalWeight = emotionalWeight;
                break;}
        }
        System.out.print(emotionalWeight);
        answer.add(emotionalWeight);

        ans = answer;
    }

}
