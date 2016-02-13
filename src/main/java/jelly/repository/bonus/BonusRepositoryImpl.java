package jelly.repository.bonus;

import jelly.entity.bonus.Bonus;
import jelly.repository.AbstractRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BonusRepositoryImpl extends AbstractRepository<Bonus> implements BonusRepository {

    public BonusRepositoryImpl() {
        super();
        setClazz(Bonus.class);
    }

    @Override
    public List<Bonus> findAll() {
        return query(Bonus.FIND_ALL);
    }
}
