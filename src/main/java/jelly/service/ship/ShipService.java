package jelly.service.ship;

import jelly.entity.ship.Ship;
import jelly.exception.ship.ShipNotFound;

import java.util.List;

public interface ShipService {
    void create(Ship level);

    Ship delete(long id) throws ShipNotFound;

    List<Ship> getAll();

    Ship update(Ship level) throws ShipNotFound;

    Ship findById(long id) throws ShipNotFound;
}
