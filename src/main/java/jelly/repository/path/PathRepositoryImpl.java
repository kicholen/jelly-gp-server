package jelly.repository.path;

import jelly.entity.path.Path;
import jelly.repository.AbstractRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PathRepositoryImpl extends AbstractRepository<Path> implements PathRepository {

    public PathRepositoryImpl() {
        super();
        setClazz(Path.class);
    }

    @Override
    public List<Path> findAll() {
        return query(Path.FIND_ALL);
    }
}
