package jelly.entity.level;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Enemy {

    @Id
    @GeneratedValue
    long id;

    float spawnBarrier;
    float speed;
    float posX;
    float posY;
    int type;
    int health;
    int path;
    int damage;

    public float getSpawnBarrier() {
        return spawnBarrier;
    }

    public float getSpeed() {
        return speed;
    }

    public float getPosX() {
        return posX;
    }

    public float getPosY() {
        return posY;
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

    public int getDamage() {
        return damage;
    }
}
