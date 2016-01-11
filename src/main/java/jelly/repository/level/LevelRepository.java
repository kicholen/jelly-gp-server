package jelly.repository.level;

import jelly.entity.level.Level;

import java.util.List;

public interface LevelRepository {
    Level findOne(long id);

    List<Level> findAll();

    void create(Level entity);

    Level update(Level entity);

    void delete(long entityId);
}
