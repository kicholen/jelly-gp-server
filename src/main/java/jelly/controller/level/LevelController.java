package jelly.controller.level;

import com.fasterxml.jackson.databind.ObjectMapper;
import jelly.entity.level.Level;
import jelly.exception.level.LevelNotFound;
import jelly.service.level.LevelService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class LevelController {

    @Resource
    LevelService service;

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/levels/{level}", method = RequestMethod.GET)
    public Level findById(@PathVariable("level") long levelId) throws LevelNotFound {
        return service.findById(levelId);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/levels", method = RequestMethod.GET)
    public Map<Long, String> getAllIds() {
        Map<Long, String> map = new HashMap<Long, String>();
        for (Level level : service.getAll()) {
            map.put(level.getId(), level.getName());
        }
        return map;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/levels/all", method = RequestMethod.GET)
    public List<Level> getAll() {
        return service.getAll();
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/levels/new/", method = RequestMethod.GET)
    public Level createLevel() {
        Level level = new Level();
        service.create(level);
        return level;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/levels/delete/{level}", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteLevel(@PathVariable("level") long levelId) throws LevelNotFound {
        service.delete(levelId);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/levels/update/", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public Level updatePath(@RequestParam(value = "data", required = true) String levelJson) throws LevelNotFound, IOException {
        Level level = getLevelFromJson(levelJson);
        return service.update(level);
    }

    Level getLevelFromJson(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, Level.class);
    }
}
