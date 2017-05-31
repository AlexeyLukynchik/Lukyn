package com.company.ThreadImpl;

import com.company.dataModul.Area;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Andrei on 01.05.2017.
 */
public class ThreadStateImpl extends Thread {

public static List<com.company.dataModul.State> st;
    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
public ThreadStateImpl(String s){

    str = s;
}
    private String str;
    @Override
    public void run() {
        ThreadStateImpl.parse(getStr());
    }
    public static void parse(String str) {

        List<com.company.dataModul.State> listState = new ArrayList<>();
        String[] array = str.split(", \"");
        Pattern nameState = Pattern.compile("[A-Z]{2}");
        com.company.dataModul.State state = null;
        for (int i = 0; i < array.length; i++) {
            Matcher matcher1 = nameState.matcher(array[i]);
            matcher1.find();
            // State state = getState(matcher1.group(),array[i]);


            state = new com.company.dataModul.State(matcher1.group());
            Pattern coordinate = Pattern.compile("\\-?[0-9]+\\.[0-9]+");
            String[] array2 = array[i].split("\\]\\]");
            for (int j = 0; j < array2.length; j++) {
                if (array2[j].equals("]"))
                    break;
                Polygon polygon = new Polygon();
                Area area = new Area();
                Matcher matcher2 = coordinate.matcher(array2[j]);
                while (matcher2.find()) {
                    Point2D.Double point = new Point2D.Double();
                    point.x = Double.parseDouble(matcher2.group());
                    matcher2.find();
                    point.y = Double.parseDouble(matcher2.group());
                    area.addPoint(point);
                    //polygon.addPoint((int) (point.x * 10 + 1850), (int) (point.y * 10 * -1 + 770));
                    polygon.addPoint((int)point.x,(int) point.y);
                }
                state.getAreas().add(area);
                state.getPolygons().add(polygon);
                listState.add(state);
            }

        }
        ThreadStateImpl.st = listState;
    }
}
