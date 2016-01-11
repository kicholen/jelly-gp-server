package jelly.service.level;

import jelly.entity.level.Level;
import jelly.exception.level.LevelNotFound;

import java.util.List;

public interface LevelService {
    void create(Level level);

    Level delete(long id) throws LevelNotFound;

    List<Level> getAll();

    Level update(Level level) throws LevelNotFound;

    Level findById(long id) throws LevelNotFound;
}
