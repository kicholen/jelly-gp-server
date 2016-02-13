package jelly.repository.difficulty;

import jelly.entity.difficulty.Difficulty;

import java.util.List;

public interface DifficultyRepository {
    Difficulty findOne(long id);

    List<Difficulty> findAll();

    void create(Difficulty entity);

    Difficulty update(Difficulty entity);

    void delete(long entityId);
}
