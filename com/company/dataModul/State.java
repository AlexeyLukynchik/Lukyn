package com.company.dataModul;

/**
 * Created by Andrei on 12.03.2017.
 * Essence for states
 */
import java.awt.*;
import java.awt.geom.Area;
import java.util.ArrayList;
import java.util.List;

public class State {
    /**
     * name of state
     * @return
     */
    public String getNameState() {
        return nameState;
    }

    public void setNameState(String nameState) {
        this.nameState = nameState;
    }

    private String nameState;
    private List<Area> areas;

    public List<Polygon> getPolygons() {
        return polygons;
    }

    public void setPolygons(List<Polygon> polygons) {
        this.polygons = polygons;
    }
/** polygons for state */
    private List<Polygon> polygons;

    public State(String nameState)
    {
        this.nameState = nameState;
        setAreas(new ArrayList<>());
        polygons = new ArrayList<>();
    }

    public String toString(){
        return "\"" + nameState + "\" : " + areasToString();
    }
    public String areasToString(){
        String string = "[";
        for(Area area : getAreas()){
            string += area.toString();
            if(area != getAreas().get(getAreas().size() - 1))
                string += ", ";
            else
                string += "]";
        }
        return string;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof State)) return false;

        State state = (State) o;

        if (nameState != null ? !nameState.equals(state.nameState) : state.nameState != null) return false;
        if (getAreas() != null ? !getAreas().equals(state.getAreas()) : state.getAreas() != null) return false;
        return polygons != null ? polygons.equals(state.polygons) : state.polygons == null;

    }

    @Override
    public int hashCode() {
        int result = nameState != null ? nameState.hashCode() : 0;
        result = 31 * result + (getAreas() != null ? getAreas().hashCode() : 0);
        result = 31 * result + (polygons != null ? polygons.hashCode() : 0);
        return result;
    }

    /**
     * area for state
     */
    public List<Area> getAreas() {
        return areas;
    }

    public void setAreas(List<Area> areas) {
        this.areas = areas;
    }
}
