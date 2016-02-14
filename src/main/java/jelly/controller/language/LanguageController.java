package jelly.controller.language;

import com.fasterxml.jackson.databind.ObjectMapper;
import jelly.entity.language.Language;
import jelly.exception.language.LanguageNotFound;
import jelly.service.language.LanguageService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class LanguageController {

    @Resource
    LanguageService service;

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/languages/{language}", method = RequestMethod.GET)
    public Language findById(@PathVariable("language") long langaugeId) throws LanguageNotFound {
        return service.findById(langaugeId);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/languages", method = RequestMethod.GET)
    public Map<Long, String> getAllIds() {
        Map<Long, String> map = new HashMap<Long, String>();
        for (Language language : service.getAll()) {
            map.put(language.getId(), language.getName());
        }
        return map;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/languages/all", method = RequestMethod.GET)
    public List<Language> getAll() {
        return service.getAll();
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/languages/new/", method = RequestMethod.GET)
    public Language createLanguage() {
        Language language = new Language();
        service.create(language);
        return language;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/languages/delete/{language}", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteLanguage(@PathVariable("language") long languageId) throws LanguageNotFound {
        service.delete(languageId);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/languages/update/", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public Language updateLanguage(@RequestParam(value = "data", required = true) String languageJson) throws LanguageNotFound, IOException {
        Language language = getLangaugeFromJson(languageJson);
        return service.update(language);
    }

    Language getLangaugeFromJson(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, Language.class);
    }
}
