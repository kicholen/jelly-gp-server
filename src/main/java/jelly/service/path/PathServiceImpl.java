package jelly.service.path;

import jelly.entity.path.Path;
import jelly.exception.path.PathNotFound;
import jelly.repository.path.PathRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PathServiceImpl implements PathService {

    @Resource
    PathRepository entity;

    @Override
    public void create(Path path) {
        entity.create(path);
    }

    @Override
    public Path delete(long id) throws PathNotFound {
        Path path = findById(id);
        entity.delete(id);
        return path;
    }

    @Override
    public List<Path> getAll() {
        return entity.findAll();
    }

    @Override
    public Path update(Path path) throws PathNotFound {
        Path savedPath = findById(path.getId());
        entity.update(path);
        return savedPath;
    }

    @Override
    public Path findById(long id) throws PathNotFound {
        Path path = entity.findOne(id);
        if (path == null)
            throw new PathNotFound();
        return entity.findOne(id);
    }
}
