package jelly.service.upgrade;

import jelly.entity.upgrade.ShipUpgrade;
import jelly.exception.upgrade.ShipUpgradeNotFound;
import jelly.repository.upgrade.ShipUpgradeRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ShipUpgradeServiceImpl implements ShipUpgradeService {

    @Resource
    ShipUpgradeRepository entity;

    @Override
    public void create(ShipUpgrade ship) {
        entity.create(ship);
    }

    @Override
    public ShipUpgrade delete(long id) throws ShipUpgradeNotFound {
        ShipUpgrade ship = findById(id);
        entity.delete(id);
        return ship;
    }

    @Override
    public List<ShipUpgrade> getAll() {
        return entity.findAll();
    }

    @Override
    public ShipUpgrade update(ShipUpgrade ship) throws ShipUpgradeNotFound {
        ShipUpgrade savedShip = findById(ship.getId());
        entity.update(ship);
        return savedShip;
    }

    @Override
    public ShipUpgrade findById(long id) throws ShipUpgradeNotFound {
        ShipUpgrade ship = entity.findOne(id);
        if (ship == null)
            throw new ShipUpgradeNotFound();
        return ship;
    }
}