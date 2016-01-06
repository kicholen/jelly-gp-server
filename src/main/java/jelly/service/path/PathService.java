package jelly.service.path;

import jelly.entity.path.Path;
import jelly.exception.path.PathNotFound;

import java.util.List;

public interface PathService {
    void create(Path path);

    Path delete(long id) throws PathNotFound;

    List<Path> getAll();

    Path update(Path path) throws PathNotFound;

    Path findById(long id) throws PathNotFound;
}
