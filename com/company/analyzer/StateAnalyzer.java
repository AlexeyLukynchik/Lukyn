package com.company.analyzer;

import com.company.parseImpl.IParse;
import com.company.dataModul.State;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Алексей on 26.03.2017.
 */
public class StateAnalyzer {
    public List<State> getListState1() {
        return listState1;
    }

    public void setListState1(List<State> listState1) {
        this.listState1 = listState1;
    }

    private List<State> listState1;
    private IParse<State> parser;
    public StateAnalyzer(IParse parser){

        listState1 = new ArrayList<>();
        this.parser = parser;

    }
    public void read() {
        try {


            BufferedReader reader = new BufferedReader(new FileReader("D:/states.json"));

        listState1  = (List<State>) parser.parse(reader.readLine());
            //listState.add(state);
        } catch (IOException e) {
            System.out.println("Error");

        }
    }
}

