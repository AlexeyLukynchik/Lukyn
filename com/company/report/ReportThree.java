package com.company.report;

import com.company.analyzer.ReportAnalyzer;
import com.company.dataModul.State;

import java.awt.geom.Point2D;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;

/**
 * Created by Алексей on 03.04.2017.
 */
public class ReportThree implements IReport<List<String>> {
    @Override
    public List<String> report(ReportAnalyzer ra, String[] str) throws Exception {
        List<String> answer = new ArrayList<>();
        Map<String, Integer> hashMap = new HashMap<String, Integer>();
        int c =0;
        for(int y =0;y<ra.stat.size();y++) {
            for (State st : ra.stat)
             hashMap.put(st.getNameState(),c);
        }
            String y = str[0];
        String y1 = str[1];
        int count = 0;
        String[] values1  = new String[ra.tw.size()];
        String num = new String();
        Date startTime = new Date();
        Date finishTime = new Date();
        for (int i = 0; i < ra.tw.size(); i++) {
           // String temp[] = ra.tw.get(i).getText().split(" ");
           // Double emotionalWeight = 0.0;
            SimpleDateFormat parserSDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {

                startTime = parserSDF.parse(y);
                finishTime = parserSDF.parse(y1);


            } catch (Exception e) {
            }
          //  System.out.println("i="+i);
            // if(i==970)
              //   System.out.println("!");
            try{
            if (startTime.before(ra.tw.get(i).getDate()) && finishTime.after(ra.tw.get(i).getDate())){

                Point2D.Double point = new Point2D.Double();
                point.x = ra.tw.get(i).getCoord().getLongitude();//Double.parseDouble(String.valueOf(ra.tw.get(i).getCoord().latitude));
                //matcher2.find();
                point.y = ra.tw.get(i).getCoord().getLatitude();//Double.parseDouble(String.valueOf(ra.tw.get(i).getCoord().longitude));
                for (int ii = 0; ii < ra.stat.size(); ii++) {
                    for(int j =0;j<ra.stat.get(ii).getPolygons().size();j++)
                    if (ra.stat.get(ii).getPolygons().get(j).contains(point) == true) {
                       // values1[count] = ra.stat.get(ii).nameState;
                        //hashMap.put(1,st1.get(i).nameState);
                        //int qq = 0;
                        //qq = hashMap.get(ra.stat.get(ii).nameState);
                        hashMap.put(ra.stat.get(ii).getNameState(),hashMap.get(ra.stat.get(ii).getNameState())+1);


                    }


                }

            }

            } catch (Exception e){break;}
        }




        List<Entry<String, Integer>> entries = new ArrayList<Entry<String, Integer>>(hashMap.entrySet());

        Collections.sort(entries, new Comparator<Entry<String, Integer>>() {
            @Override
            public int compare(Entry<String, Integer> e1, Entry<String, Integer> e2) {
                int v1 = e1.getValue();
                int v2 = e2.getValue();
                return (v1 < v2) ? 1 : (v1 == v2) ? 0 : -1;

            }

        });
        for (Entry<String,Integer> t : entries)
        {
            System.out.println("key/value: " + t.getKey() + "/" + t.getValue());
        }


        //TreeMap<String,Integer> tm = new TreeMap<>(hashMap);
       // Integer[] val = new Integer[hashMap.size()];
        //int t = 0;
        //for (int value : hashMap.values()) {
         //   val[t] = value;
//t++;
  //      }
    //     Arrays.sort(val);
      //  System.out.print(val[hashMap.size()-1]);
        return answer;
    }
}





