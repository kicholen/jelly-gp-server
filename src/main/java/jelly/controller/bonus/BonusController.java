package jelly.controller.bonus;

import com.fasterxml.jackson.databind.ObjectMapper;
import jelly.entity.bonus.Bonus;
import jelly.exception.bonus.BonusNotFound;
import jelly.service.bonus.BonusService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BonusController {

    @Resource
    BonusService service;

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/bonuses/{bonus}", method = RequestMethod.GET)
    public Bonus findById(@PathVariable("bonus") long bonusId) throws BonusNotFound {
        return service.findById(bonusId);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/bonuses", method = RequestMethod.GET)
    public Map<Long, String> getAllIds() {
        Map<Long, String> map = new HashMap<Long, String>();
        for (Bonus bonus : service.getAll()) {
            map.put(bonus.getId(), String.valueOf(bonus.getType()));
        }
        return map;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/bonuses/all", method = RequestMethod.GET)
    public List<Bonus> getAll() {
        return service.getAll();
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/bonuses/new/", method = RequestMethod.GET)
    public Bonus createBonus() {
        Bonus bonus = new Bonus();
        bonus.setType(getNextType());
        service.create(bonus);
        return bonus;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/bonuses/delete/{bonus}", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteBonus(@PathVariable("bonus") long bonusId) throws BonusNotFound {
        service.delete(bonusId);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/bonuses/update/", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public Bonus updateBonus(@RequestParam(value = "data", required = true) String bonusJson) throws BonusNotFound, IOException {
        Bonus bonus = getBonusFromJson(bonusJson);
        return service.update(bonus);
    }

    Bonus getBonusFromJson(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, Bonus.class);
    }

    int getNextType() {
        int type = 0;
        for (Bonus bonus : service.getAll()) {
            int value = bonus.getType();
            if (value > type) {
                type = value;
            }
        }
        return type + 1;
    }
}
