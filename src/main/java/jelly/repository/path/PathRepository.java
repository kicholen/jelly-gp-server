package jelly.repository.path;

import jelly.entity.path.Path;

import java.util.List;

public interface PathRepository {
    Path findOne(long id);

    List<Path> findAll();

    void create(Path entity);

    Path update(Path entity);

    void delete(long entityId);
}
