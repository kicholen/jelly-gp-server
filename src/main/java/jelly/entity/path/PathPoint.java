package jelly.entity.path;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class PathPoint implements Serializable {

    @Id
    @GeneratedValue
    long id;
    double x;
    double y;

    public PathPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
