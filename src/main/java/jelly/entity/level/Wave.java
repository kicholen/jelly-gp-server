package jelly.entity.level;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Wave {

    @Id
    @GeneratedValue
    long id;

    float spawnBarrier;
    int count;
    float spawnOffset;
    float speed;
    int type;
    int health;
    int path;
    int grid;
    int damage;

    public float getSpawnBarrier() {
        return spawnBarrier;
    }

    public int getCount() {
        return count;
    }

    public float getSpawnOffset() {
        return spawnOffset;
    }

    public float getSpeed() {
        return speed;
    }

    public int getType() {
        return type;
    }

    public int getHealth() {
        return health;
    }

    public int getPath() {
        return path;
    }

    public int getGrid() {
        return grid;
    }

    public int getDamage() {
        return damage;
    }
}
