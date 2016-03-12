package jelly.controller.ship;

import com.fasterxml.jackson.databind.ObjectMapper;
import jelly.entity.ship.Ship;
import jelly.exception.ship.ShipNotFound;
import jelly.service.ship.ShipService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ShipController {

    @Resource
    ShipService service;

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/ships/{ship}", method = RequestMethod.GET)
    public Ship findById(@PathVariable("ship") long shipId) throws ShipNotFound {
        return service.findById(shipId);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/ships", method = RequestMethod.GET)
    public Map<Long, Integer> getAllIds() throws ShipNotFound {
        setScoreColumn();
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        for (Ship ship : service.getAll()) {
            map.put(ship.getId(), ship.getType());
        }
        return map;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/ships/all", method = RequestMethod.GET)
    public List<Ship> getAll() {
        return service.getAll();
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/ships/new/", method = RequestMethod.GET)
    public Ship createShip() {
        Ship ship = new Ship();
        ship.setType(getNextType());
        service.create(ship);
        return ship;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/ships/delete/{ship}", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteShip(@PathVariable("ship") long shipId) throws ShipNotFound {
        service.delete(shipId);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/ships/update/", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public Ship updateShip(@RequestParam(value = "data", required = true) String shipJson) throws ShipNotFound, IOException {
        Ship ship = getShipFromJson(shipJson);
        return service.update(ship);
    }

    Ship getShipFromJson(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, Ship.class);
    }

    int getNextType() {
        int lastType = 0;
        for (Ship ship : service.getAll()) {
            int value = ship.getType();
            if (value > lastType) {
                lastType = value;
            }
        }
        return lastType + 1;
    }

    void setScoreColumn() throws ShipNotFound {
        for (Ship ship : service.getAll()) {
            ship.setScore(1);
            service.update(ship);
        }
    }
}
