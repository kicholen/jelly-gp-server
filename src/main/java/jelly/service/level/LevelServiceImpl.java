package jelly.service.level;

import jelly.entity.level.Level;
import jelly.exception.level.LevelNotFound;
import jelly.repository.level.LevelRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LevelServiceImpl implements LevelService {

    @Resource
    LevelRepository entity;

    @Override
    public void create(Level level) {
        entity.create(level);
    }

    @Override
    public Level delete(long id) throws LevelNotFound {
        Level level = findById(id);
        entity.delete(id);
        return level;
    }

    @Override
    public List<Level> getAll() {
        return entity.findAll();
    }

    @Override
    public Level update(Level level) throws LevelNotFound {
        Level savedLevel = findById(level.getId());
        entity.update(level);
        return savedLevel;
    }

    @Override
    public Level findById(long id) throws LevelNotFound {
        Level level = entity.findOne(id);
        if (level == null)
            throw new LevelNotFound();
        return entity.findOne(id);
    }
}
