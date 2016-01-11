package jelly.entity.level;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries({@NamedQuery(name = Level.FIND_ALL, query = "SELECT c FROM Level c"),
        @NamedQuery(name = Level.DELETE_ALL, query = "DELETE FROM Level c")})
public class Level implements Serializable {
    public final static String FIND_ALL = "Level.findAll";
    public final static String DELETE_ALL = "Level.deleteAll";

    @Id
    @GeneratedValue
    long id;
    String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    List<Wave> waves = new ArrayList<Wave>();
    int waveIndex;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    List<Enemy> enemies = new ArrayList<Enemy>();
    int enemyIndex;

    Vector2 position = new Vector2();
    Vector2 size = new Vector2();

    public long getId() {
        return id;
    }

    public void setId(final long value) {
        id = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        name = value;
    }

    public List<Wave> getWaves() {
        return waves;
    }

    public int getWaveIndex() {
        return waveIndex;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public int getEnemyIndex() {
        return enemyIndex;
    }

    public Vector2 getPosition() {
        return position;
    }

    public Vector2 getSize() {
        return size;
    }
}
