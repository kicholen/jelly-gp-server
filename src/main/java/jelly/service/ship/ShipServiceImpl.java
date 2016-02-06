package jelly.service.ship;

import jelly.entity.ship.Ship;
import jelly.exception.ship.ShipNotFound;
import jelly.repository.ship.ShipRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ShipServiceImpl implements ShipService {

    @Resource
    ShipRepository entity;

    @Override
    public void create(Ship ship) {
        entity.create(ship);
    }

    @Override
    public Ship delete(long id) throws ShipNotFound {
        Ship ship = findById(id);
        entity.delete(id);
        return ship;
    }

    @Override
    public List<Ship> getAll() {
        return entity.findAll();
    }

    @Override
    public Ship update(Ship ship) throws ShipNotFound {
        Ship savedShip = findById(ship.getId());
        entity.update(ship);
        return savedShip;
    }

    @Override
    public Ship findById(long id) throws ShipNotFound {
        Ship ship = entity.findOne(id);
        if (ship == null)
            throw new ShipNotFound();
        return entity.findOne(id);
    }
}