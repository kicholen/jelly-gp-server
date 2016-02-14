package jelly.service.language;

import jelly.entity.language.Language;
import jelly.exception.language.LanguageNotFound;
import jelly.repository.language.LanguageRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LanguageServiceImpl implements LanguageService {

    @Resource
    LanguageRepository entity;

    @Override
    public void create(Language language) {
        entity.create(language);
    }

    @Override
    public Language delete(long id) throws LanguageNotFound {
        Language language = findById(id);
        entity.delete(id);
        return language;
    }

    @Override
    public List<Language> getAll() {
        return entity.findAll();
    }

    @Override
    public Language update(Language language) throws LanguageNotFound {
        Language savedLanguage = findById(language.getId());
        entity.update(language);
        return savedLanguage;
    }

    @Override
    public Language findById(long id) throws LanguageNotFound {
        Language language = entity.findOne(id);
        if (language == null)
            throw new LanguageNotFound();
        return language;
    }
}
