package jelly.controller.level;

import com.fasterxml.jackson.databind.ObjectMapper;
import jelly.entity.level.Level;
import jelly.exception.level.LevelNotFound;
import jelly.service.level.LevelService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class LevelController {

    @Resource
    LevelService service;

    @RequestMapping(value = "/levels/{level}", method = RequestMethod.GET)
    public Level findById(@PathVariable("level") long levelId) throws LevelNotFound {
        return service.findById(levelId);
    }

    @RequestMapping(value = "/levels", method = RequestMethod.GET)
    public List<Long> getAll() {
        return service.getAll()
                .stream().map(Level::getId)
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/levels/new/", method = RequestMethod.GET)
    public Level createLevel() {
        Level level = new Level();
        service.create(level);
        return level;
    }

    @RequestMapping(value = "/levels/delete/{level}", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteLevel(@PathVariable("level") long levelId) throws LevelNotFound {
        service.delete(levelId);
    }

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
