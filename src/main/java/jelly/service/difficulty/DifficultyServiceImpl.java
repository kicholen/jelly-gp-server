package jelly.service.difficulty;

import jelly.entity.difficulty.Difficulty;
import jelly.exception.difficulty.DifficultyNotFound;
import jelly.repository.difficulty.DifficultyRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DifficultyServiceImpl implements DifficultyService {

    @Resource
    DifficultyRepository entity;

    @Override
    public void create(Difficulty difficulty) {
        entity.create(difficulty);
    }

    @Override
    public Difficulty delete(long id) throws DifficultyNotFound {
        Difficulty difficulty = findById(id);
        entity.delete(id);
        return difficulty;
    }

    @Override
    public List<Difficulty> getAll() {
        return entity.findAll();
    }

    @Override
    public Difficulty update(Difficulty difficulty) throws DifficultyNotFound {
        Difficulty savedDifficulty = findById(difficulty.getId());
        entity.update(difficulty);
        return savedDifficulty;
    }

    @Override
    public Difficulty findById(long id) throws DifficultyNotFound {
        Difficulty difficulty = entity.findOne(id);
        if (difficulty == null)
            throw new DifficultyNotFound();
        return difficulty;
    }
}
