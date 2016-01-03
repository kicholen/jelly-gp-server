package jelly.controller.path;

import jelly.entity.path.Path;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class PathController {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value="/paths/{path}", method=RequestMethod.GET)
    public Path test(@PathVariable("path") long pathId) {

        return new Path(pathId);
    }
}
