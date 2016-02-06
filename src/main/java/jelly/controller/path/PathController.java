package jelly.controller.path;

import com.fasterxml.jackson.databind.ObjectMapper;
import jelly.entity.path.Path;
import jelly.exception.path.PathNotFound;
import jelly.service.path.PathService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PathController {

    @Resource
    PathService service;

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/paths/{path}", method = RequestMethod.GET)
    public Path findById(@PathVariable("path") long pathId) throws PathNotFound {
        return service.findById(pathId);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/paths", method = RequestMethod.GET)
    public Map<Long, String> getAllIds() {
        Map<Long, String> map = new HashMap<Long, String>();
        for (Path path : service.getAll()) {
            map.put(path.getId(), path.getName());
        }
        return map;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/paths/all", method = RequestMethod.GET)
    public List<Path> getAll() {
        return service.getAll();
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/paths/new/", method = RequestMethod.GET)
    public Path createPath() {
        Path path = new Path();
        path.setName(getNextName());
        service.create(path);
        return path;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/paths/delete/{path}", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void deletePath(@PathVariable("path") long pathId) throws PathNotFound {
        service.delete(pathId);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/paths/update/", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public Path updatePath(@RequestParam(value = "data", required = true) String pathJson) throws PathNotFound, IOException {
        Path path = getPathFromJson(pathJson);
        return service.update(path);
    }

    Path getPathFromJson(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, Path.class);
    }

    String getNextName() {
        int name = 0;
        for (Path path : service.getAll()) {
            int value = Integer.parseInt(path.getName());
            if (value > name) {
                name = value;
            }
        }
        return String.valueOf(name + 1);
    }
}
