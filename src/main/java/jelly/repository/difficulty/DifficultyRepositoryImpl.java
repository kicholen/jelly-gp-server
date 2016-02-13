package jelly.repository.difficulty;

import jelly.entity.difficulty.Difficulty;
import jelly.repository.AbstractRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DifficultyRepositoryImpl extends AbstractRepository<Difficulty> implements DifficultyRepository {

    public DifficultyRepositoryImpl() {
        super();
        setClazz(Difficulty.class);
    }

    @Override
    public List<Difficulty> findAll() {
        return query(Difficulty.FIND_ALL);
    }
}
