package jelly.entity.level;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Vector2 implements Serializable {

    @Id
    @GeneratedValue
    long id;
    float x;
    float y;

    public Vector2() {
        super();
    }

    public Vector2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
