package com.company.report;

import com.company.analyzer.ReportAnalyzer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Алексей on 03.04.2017.
 */
public class ReportTwo implements IReport<List<Double>> {
    @Override
    public List<Double> report(ReportAnalyzer ra, String[] str) throws Exception {

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
                            if (temp[j] == ra.sent.get(ii).getValue().toLowerCase())
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
        return answer;
    }

}

