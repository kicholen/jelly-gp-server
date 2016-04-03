package jelly.service.upgrade;

import jelly.entity.upgrade.ShipUpgrade;
import jelly.exception.upgrade.ShipUpgradeNotFound;

import java.util.List;

public interface ShipUpgradeService {
    void create(ShipUpgrade level);

    ShipUpgrade delete(long id) throws ShipUpgradeNotFound;

    List<ShipUpgrade> getAll();

    ShipUpgrade update(ShipUpgrade level) throws ShipUpgradeNotFound;

    ShipUpgrade findById(long id) throws ShipUpgradeNotFound;
}
