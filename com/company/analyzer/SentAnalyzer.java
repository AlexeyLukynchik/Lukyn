package com.company.analyzer;

import com.company.parseImpl.IParse;
import com.company.dataModul.Sentiment;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Алексей on 26.03.2017.
 */
public class SentAnalyzer  {
    private List<Sentiment> listSent;

    public List<Sentiment> getListSent() {
        return listSent;
    }

    public void setListSent(List<Sentiment> listSent) {
        this.listSent = listSent;
    }

    private IParse<Sentiment> parser;
    public SentAnalyzer(IParse parser){

        listSent = new ArrayList<>();
        this.parser = parser;

    }


    public  void read() {
        try {
            FileInputStream fstream = new FileInputStream("D:/sentiments.csv");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                if (strLine == null){
                    break;}
                else {
                    Sentiment sent = parser.parse(strLine);
                    listSent.add(sent);
                }

            }

            } catch (IOException e) {
                System.out.println("Error");

            }
    }


}
