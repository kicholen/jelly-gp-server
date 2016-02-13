package jelly.controller.difficulty;

import com.fasterxml.jackson.databind.ObjectMapper;
import jelly.entity.difficulty.Difficulty;
import jelly.exception.difficulty.DifficultyNotFound;
import jelly.service.difficulty.DifficultyService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class DifficultyController {

    @Resource
    DifficultyService service;

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/difficulties/{difficulty}", method = RequestMethod.GET)
    public Difficulty findById(@PathVariable("difficulty") long difficultyId) throws DifficultyNotFound {
        return service.findById(difficultyId);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/difficulties", method = RequestMethod.GET)
    public Map<Long, String> getAllIds() {
        Map<Long, String> map = new HashMap<Long, String>();
        for (Difficulty difficulty : service.getAll()) {
            map.put(difficulty.getId(), String.valueOf(difficulty.getType()));
        }
        return map;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/difficulties/all", method = RequestMethod.GET)
    public List<Difficulty> getAll() {
        return service.getAll();
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/difficulties/new/", method = RequestMethod.GET)
    public Difficulty createDifficulty() {
        Difficulty difficulty = new Difficulty();
        difficulty.setType(getNextType());
        service.create(difficulty);
        return difficulty;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/difficulties/delete/{difficulty}", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteDifficulty(@PathVariable("difficulty") long difficultyId) throws DifficultyNotFound {
        service.delete(difficultyId);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/difficulties/update/", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public Difficulty updateDifficulty(@RequestParam(value = "data", required = true) String difficultyJson) throws DifficultyNotFound, IOException {
        Difficulty difficulty = getDifficultyFromJson(difficultyJson);
        return service.update(difficulty);
    }

    Difficulty getDifficultyFromJson(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, Difficulty.class);
    }

    int getNextType() {
        int type = 0;
        for (Difficulty difficulty : service.getAll()) {
            int value = difficulty.getType();
            if (value > type) {
                type = value;
            }
        }
        return type + 1;
    }
}
