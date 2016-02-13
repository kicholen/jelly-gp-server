package jelly.service.difficulty;

import jelly.entity.difficulty.Difficulty;
import jelly.exception.difficulty.DifficultyNotFound;

import java.util.List;

public interface DifficultyService {
    void create(Difficulty difficulty);

    Difficulty delete(long id) throws DifficultyNotFound;

    List<Difficulty> getAll();

    Difficulty update(Difficulty difficulty) throws DifficultyNotFound;

    Difficulty findById(long id) throws DifficultyNotFound;
}
