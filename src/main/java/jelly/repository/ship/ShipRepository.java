package jelly.repository.ship;

import jelly.entity.ship.Ship;

import java.util.List;

public interface ShipRepository {
    Ship findOne(long id);

    List<Ship> findAll();

    void create(Ship entity);

    Ship update(Ship entity);

    void delete(long entityId);
}
