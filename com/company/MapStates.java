package com.company;

import com.company.dataModul.State;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Random;

/**
 * Created by Andrei on 13.04.2017.
 */
public class MapStates extends JFrame {

    private static final String title = "States";
    private static final boolean visible = true;
    private static final int width = 1700;
    private static final int height = 720;
    private List<State> states;

    public MapStates(List<State> states){
        super(title);
        this.setSize(width,height);
        this.setVisible(visible);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.states = states;
    }


    public void paint(Graphics g){
        int i = 0;
        Random r = new Random();
        for (State state : states){
            for (Polygon polygon : state.getPolygons()){
               // g.setColor(new Color(255, 61, 35));
                g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
                g.fillPolygon(polygon);

            }
            i++;
            for (Polygon polygon : state.getPolygons()){
                g.setColor(Color.black);
                g.drawPolygon(polygon);
            }
        }
    }






}
