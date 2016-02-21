package jelly.entity.ship;

import jelly.entity.level.Vector2;

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

    int amount;
    float time;
    float spawnDelay;
    String weaponResource;
    float velocity;
    int angle;
    int angleOffset;
    int waves;
    Vector2 startVelocity = new Vector2();
    float followDelay;
    float selfDestructionDelay;
    float timeDelay;
    float delay;
    float randomPositionOffsetX;

    Boolean faceDirection;
    @Column(nullable = true)
    Integer shakeCamera;
    @Column(nullable = true)
    Float randomRotation;

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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int value) {
        amount = value;
    }

    public float getTime() {
        return time;
    }

    public void setTime(float value) {
        time = value;
    }

    public float getSpawnDelay() {
        return spawnDelay;
    }

    public void setSpawnDelay(float value) {
        spawnDelay = value;
    }

    public String getWeaponResource() {
        return weaponResource;
    }

    public void setWeaponResource(String value) {
        weaponResource = value;
    }

    public float getVelocity() {
        return velocity;
    }

    public void setVelocity(float value) {
        velocity = value;
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int value) {
        angle = value;
    }

    public int getAngleOffset() {
        return angleOffset;
    }

    public void setAngleOffset(int value) {
        angleOffset = value;
    }

    public int getWaves() {
        return waves;
    }

    public void setWaves(int value) {
        waves = value;
    }

    public float getFollowDelay() {
        return followDelay;
    }

    public void setFollowDelay(float value) {
        followDelay = value;
    }

    public float getSelfDestructionDelay() {
        return selfDestructionDelay;
    }

    public void setSelfDestructionDelay(float value) {
        selfDestructionDelay = value;
    }

    public float getTimeDelay() {
        return timeDelay;
    }

    public void setTimeDelay(float value) {
        timeDelay = value;
    }

    public float getDelay() {
        return delay;
    }

    public void setDelay(float value) {
        delay = value;
    }

    public float getRandomPositionOffsetX() {
        return randomPositionOffsetX;
    }

    public void setRandomPositionOffsetX(float value) {
        randomPositionOffsetX = value;
    }

    public Vector2 getStartVelocity() {
        return startVelocity;
    }

    public void setStartVelocity(Vector2 value) {
        startVelocity = value;
    }

    public Boolean getFaceDirection() {
        return faceDirection;
    }

    public void setFaceDirection(Boolean faceDirection) {
        this.faceDirection = faceDirection;
    }

    public int getShakeCamera() {
        return shakeCamera;
    }

    public void setShakeCamera(Integer shakeCamera) {
        this.shakeCamera = shakeCamera == null ? 0 : shakeCamera;
    }

    public float getRandomRotation() {
        return randomRotation;
    }

    public void setRandomRotation(Float randomRotation) {
        this.randomRotation = randomRotation == null ? 0 : randomRotation;
    }
}

