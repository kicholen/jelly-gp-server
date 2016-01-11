package jelly.repository.level;

import jelly.entity.level.Level;
import jelly.repository.AbstractRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LevelRepositoryImpl extends AbstractRepository<Level> implements LevelRepository {

    public LevelRepositoryImpl() {
        super();
        setClazz(Level.class);
    }

    @Override
    public List<Level> findAll() {
        return query(Level.FIND_ALL);
    }
}
