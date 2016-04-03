package jelly.controller.upgrade;

import com.fasterxml.jackson.databind.ObjectMapper;
import jelly.entity.upgrade.ShipUpgrade;
import jelly.exception.upgrade.ShipUpgradeNotFound;
import jelly.service.upgrade.ShipUpgradeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ShipUpgradeController {

    @Resource
    ShipUpgradeService service;

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/upgrades/{upgrade}", method = RequestMethod.GET)
    public ShipUpgrade findById(@PathVariable("upgrade") long upgradeId) throws ShipUpgradeNotFound {
        return service.findById(upgradeId);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/upgrades", method = RequestMethod.GET)
    public Map<Long, Integer> getAllIds() {
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        for (ShipUpgrade upgrade : service.getAll()) {
            map.put(upgrade.getId(), upgrade.getType());
        }
        return map;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/upgrades/all", method = RequestMethod.GET)
    public List<ShipUpgrade> getAll() {
        return service.getAll();
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/upgrades/new/", method = RequestMethod.GET)
    public ShipUpgrade createUpgrade() {
        ShipUpgrade upgrade = new ShipUpgrade();
        service.create(upgrade);
        return upgrade;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/upgrades/delete/{upgrade}", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteUpgrade(@PathVariable("upgrade") long upgradeId) throws ShipUpgradeNotFound {
        service.delete(upgradeId);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/upgrades/update/", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public ShipUpgrade updateUpgrade(@RequestParam(value = "data", required = true) String upgradeJson) throws ShipUpgradeNotFound, IOException {
        ShipUpgrade upgrade = getUpgradeFromJson(upgradeJson);
        return service.update(upgrade);
    }

    ShipUpgrade getUpgradeFromJson(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, ShipUpgrade.class);
    }
}
