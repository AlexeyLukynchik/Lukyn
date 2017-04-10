package com.company.dataModul;

/**
 * Created by Алексей on 12.03.2017.
 */
import java.util.Date;

/**
 * Created by Алексей on 01.03.2017.
 */
public class Tweet {
    public  class GeoCord
    {
        public Double getLatitude() {
            return latitude;
        }

        public void setLatitude(Double latitude) {
            this.latitude = latitude;
        }

        private Double latitude ;

        public Double getLongitude() {
            return longitude;
        }

        public void setLongitude(Double longitude) {
            this.longitude = longitude;
        }

        private Double longitude ;

    public  GeoCord(Double latitude1, Double longitude1){
            latitude = latitude1;
            longitude = longitude1;

        }
    }

    public GeoCord getCoord() {
        return coord;
    }

    public void setCoord(GeoCord coord) {
        this.coord = coord;
    }

    private GeoCord coord;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    private Date date ;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    private     String text;

   public Tweet(Date date1,  String text1){


        date = date1;

        text = text1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tweet)) return false;

        Tweet tweet = (Tweet) o;

        if (date != null ? !date.equals(tweet.date) : tweet.date != null) return false;
        return text != null ? text.equals(tweet.text) : tweet.text == null;

    }

    @Override
    public int hashCode() {
        int result = date != null ? date.hashCode() : 0;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "date=" + date +
                ", text='" + text + '\'' +
                '}';
    }
}



