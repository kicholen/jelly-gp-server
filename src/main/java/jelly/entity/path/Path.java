package jelly.entity.path;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Path implements Serializable {

    @Id
    @GeneratedValue
    long id;

    @OneToMany
    List<PathPoint> points = new ArrayList<PathPoint>();

    public Path(long id) {
        this.id = id;
        points.add(new PathPoint(0.0232, 0.555));
        points.add(new PathPoint(0.4232, 0.32555));
        points.add(new PathPoint(0.12232, 0.542455));
        points.add(new PathPoint(0.024332, 0.55545));
    }

    public long getId() {
        return id;
    }

    public List<PathPoint> getPoints() {
        return points;
    }
}
