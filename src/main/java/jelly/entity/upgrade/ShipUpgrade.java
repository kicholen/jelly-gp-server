package jelly.entity.upgrade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries({@NamedQuery(name = ShipUpgrade.FIND_ALL, query = "SELECT c FROM ShipUpgrade c"),
        @NamedQuery(name = ShipUpgrade.DELETE_ALL, query = "DELETE FROM ShipUpgrade c")})
public class ShipUpgrade implements Serializable {
    public final static String FIND_ALL = "ShipUpgrade.findAll";
    public final static String DELETE_ALL = "ShipUpgrade.deleteAll";

    @Id
    @GeneratedValue
    long id;
    int type;
    String title;
    String description;

    @ElementCollection
    List<Integer> cost = new ArrayList<Integer>();
    @ElementCollection
    List<Double> bonus = new ArrayList<Double>();
    @ElementCollection
    List<Double> duration = new ArrayList<Double>();

    public long getId() {
        return id;
    }

    public void setId(final long value) {
        id = value;
    }

    public int getType() {
        return type;
    }

    public void setType(final int value) {
        type = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String value) {
        title = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String value) {
        description = value;
    }

    public List<Integer> getCost() {
        return cost;
    }

    public void setCost(List<Integer> value) {
        cost = value;
    }

    public List<Double> getBonus() {
        return bonus;
    }

    public void setBonus(List<Double> value) {
        bonus = value;
    }

    public List<Double> getDuration() {
        return duration;
    }

    public void setDuration(List<Double> value) {
        duration = value;
    }
}
