package jelly.repository.upgrade;

import jelly.entity.upgrade.ShipUpgrade;

import java.util.List;

public interface ShipUpgradeRepository {
    ShipUpgrade findOne(long id);

    List<ShipUpgrade> findAll();

    void create(ShipUpgrade entity);

    ShipUpgrade update(ShipUpgrade entity);

    void delete(long entityId);
}
