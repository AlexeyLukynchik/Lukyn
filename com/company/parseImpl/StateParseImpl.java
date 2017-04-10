package com.company.parseImpl;

import com.company.dataModul.Area;
import com.company.dataModul.State;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Алексей on 27.03.2017.
 */
public class StateParseImpl implements IParse<List<State>> {

    @Override
    public List<State> parse(String str) {

        List<State> listState = new ArrayList<>();
        String[] array = str.split(", \"");
        Pattern nameState = Pattern.compile("[A-Z]{2}");
        State state = null;
        for (int i = 0; i < array.length; i++) {
            Matcher matcher1 = nameState.matcher(array[i]);
            matcher1.find();
            // State state = getState(matcher1.group(),array[i]);


            state = new State(matcher1.group());
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
                state.areas.add(area);
                state.getPolygons().add(polygon);
                listState.add(state);
            }

        }
        return listState;
    }

}

