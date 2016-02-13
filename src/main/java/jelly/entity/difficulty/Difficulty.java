package jelly.entity.difficulty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries({@NamedQuery(name = Difficulty.FIND_ALL, query = "SELECT c FROM Difficulty c"),
        @NamedQuery(name = Difficulty.DELETE_ALL, query = "DELETE FROM Difficulty c")})
public class Difficulty implements Serializable {
    public final static String FIND_ALL = "Difficulty.findAll";
    public final static String DELETE_ALL = "Difficulty.deleteAll";

    @Id
    @GeneratedValue
    long id;
    int type;

    int hpBoostPercent;
    int dmgBoostPercent;
    int missileSpeedBoostPercent;

    public long getId() {
        return id;
    }

    public void setId(final long value) {
        id = value;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getHpBoostPercent() {
        return hpBoostPercent;
    }

    public void setHpBoostPercent(int hpBoostPercent) {
        this.hpBoostPercent = hpBoostPercent;
    }

    public int getDmgBoostPercent() {
        return dmgBoostPercent;
    }

    public void setDmgBoostPercent(int dmgBoostPercent) {
        this.dmgBoostPercent = dmgBoostPercent;
    }

    public int getMissileSpeedBoostPercent() {
        return missileSpeedBoostPercent;
    }

    public void setMissileSpeedBoostPercent(int missileSpeedBoostPercent) {
        this.missileSpeedBoostPercent = missileSpeedBoostPercent;
    }
}
