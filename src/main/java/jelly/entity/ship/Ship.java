package jelly.entity.ship;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NamedQueries({@NamedQuery(name = Ship.FIND_ALL, query = "SELECT c FROM Ship c"),
        @NamedQuery(name = Ship.DELETE_ALL, query = "DELETE FROM Ship c")})
public class Ship implements Serializable {
    public final static String FIND_ALL = "Ship.findAll";
    public final static String DELETE_ALL = "Ship.deleteAll";

    @Id
    @GeneratedValue
    long id;

    int type;

    String resource;

    int weapon;

    public long getId() {
        return id;
    }

    public void setId(final long value) {
        id = value;
    }

    public int getType() {
        return type;
    }

    public void setType(int value) {
        type = value;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String value) {
        resource = value;
    }

    public int getWeapon() {
        return weapon;
    }

    public void setWeapon(int value) {
        weapon = value;
    }
}

