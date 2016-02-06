package jelly.repository.ship;

import jelly.entity.ship.Ship;
import jelly.repository.AbstractRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ShipRepositoryImpl extends AbstractRepository<Ship> implements ShipRepository {

    public ShipRepositoryImpl() {
        super();
        setClazz(Ship.class);
    }

    @Override
    public List<Ship> findAll() {
        return query(Ship.FIND_ALL);
    }
}