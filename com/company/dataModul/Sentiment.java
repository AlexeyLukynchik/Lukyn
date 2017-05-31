package com.company.dataModul;

/**
 * Created by Andrei on 12.03.2017.
 * Essence for sentiment
 */public class Sentiment {

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
   /** value of sentiment */
    private String value;

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }
/** weight of sentiment */
    private Float weight ;

   public Sentiment(String value1, Float weight1){
        value = value1;
        weight = weight1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sentiment)) return false;

        Sentiment that = (Sentiment) o;

        if (value != null ? !value.equals(that.value) : that.value != null) return false;
        return weight != null ? weight.equals(that.weight) : that.weight == null;

    }

    @Override
    public int hashCode() {
        int result = value != null ? value.hashCode() : 0;
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Sentiment{" +
                "value='" + value + '\'' +
                ", weight=" + weight +
                '}';
    }
}

