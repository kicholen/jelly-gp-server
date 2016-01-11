package jelly.entity.path;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries({@NamedQuery(name = Path.FIND_ALL, query = "SELECT c FROM Path c"),
        @NamedQuery(name = Path.DELETE_ALL, query = "DELETE FROM Path c")})
public class Path implements Serializable {
    public final static String FIND_ALL = "Path.findAll";
    public final static String DELETE_ALL = "Path.deleteAll";

    @Id
    @GeneratedValue
    long id;
    String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<PathPoint> points = new ArrayList<PathPoint>();

    public long getId() {
        return id;
    }

    public void setId(final long value) {
        id = value;
    }

    public List<PathPoint> getPoints() {
        return points;
    }

    public void setPoints(List<PathPoint> value) {
        points = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        name = value;
    }
}
