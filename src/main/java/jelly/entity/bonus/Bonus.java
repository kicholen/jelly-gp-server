package jelly.entity.bonus;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NamedQueries({@NamedQuery(name = Bonus.FIND_ALL, query = "SELECT c FROM Bonus c"),
        @NamedQuery(name = Bonus.DELETE_ALL, query = "DELETE FROM Bonus c")})
public class Bonus implements Serializable {
    public final static String FIND_ALL = "Bonus.findAll";
    public final static String DELETE_ALL = "Bonus.deleteAll";

    @Id
    @GeneratedValue
    long id;
    int type;

    int minAmount;
    int maxAmount;
    float probability;
    String resource;

    public long getId() {
        return id;
    }

    public void setId(final long value) {
        id = value;
    }

    public float getProbability() {
        return probability;
    }

    public void setProbability(float probability) {
        this.probability = probability;
    }

    public int getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(int maxAmount) {
        this.maxAmount = maxAmount;
    }

    public int getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(int minAmount) {
        this.minAmount = minAmount;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }
}
