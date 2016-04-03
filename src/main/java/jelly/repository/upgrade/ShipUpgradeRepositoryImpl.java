package jelly.repository.upgrade;

import jelly.entity.upgrade.ShipUpgrade;
import jelly.repository.AbstractRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ShipUpgradeRepositoryImpl extends AbstractRepository<ShipUpgrade> implements ShipUpgradeRepository {

    public ShipUpgradeRepositoryImpl() {
        super();
        setClazz(ShipUpgrade.class);
    }

    @Override
    public List<ShipUpgrade> findAll() {
        return query(ShipUpgrade.FIND_ALL);
    }
}