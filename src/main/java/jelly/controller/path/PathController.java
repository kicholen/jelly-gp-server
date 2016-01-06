package jelly.controller.path;

import jelly.entity.path.Path;
import jelly.entity.path.PathPoint;
import jelly.exception.path.PathNotFound;
import jelly.service.path.PathService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;

// todo change get to post/delete
@RestController
public class PathController {

    @Resource
    PathService service;

    @RequestMapping(value = "/paths/{path}", method = RequestMethod.GET)
    public Path findById(@PathVariable("path") long pathId) throws PathNotFound {
        return service.findById(pathId);
    }

    @RequestMapping(value = "/paths", method = RequestMethod.GET)
    public List<Path> getAll() {
        List<Path> paths = service.getAll();
        return paths;
    }

    @RequestMapping(value = "/paths/delete/{path}", method = RequestMethod.GET)
    public Path deletePath(@PathVariable("path") long pathId) throws PathNotFound {
        service.delete(pathId);
        return new Path();
    }

    @RequestMapping(value = "/paths/new/{path}", method = RequestMethod.GET)
    public Path createPath(@PathVariable("path") long pathId) {
        Path path = new Path();
        List<PathPoint> points = new ArrayList<PathPoint>();
        points.add(new PathPoint(10.02, 43.23));
        points.add(new PathPoint(132.22, 12.532));
        points.add(new PathPoint(10.0124, 532.234));
        points.add(new PathPoint(321.3524, 31.76));
        path.setPoints(points);
        service.create(path);
        return path;
    }

    @RequestMapping(value = "/paths/update/{path}", method = RequestMethod.GET)
    public Path updatePath(@PathVariable("path") long pathId) throws PathNotFound {
        Path path = service.findById(pathId);
        List<PathPoint> points = path.getPoints();
        points.add(new PathPoint(10.02111, 0));
        path.setPoints(points);
        return service.update(path);
    }
}
