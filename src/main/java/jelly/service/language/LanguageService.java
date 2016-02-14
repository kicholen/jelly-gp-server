package jelly.service.language;

import jelly.entity.language.Language;
import jelly.exception.language.LanguageNotFound;

import java.util.List;

public interface LanguageService {
    void create(Language language);

    Language delete(long id) throws LanguageNotFound;

    List<Language> getAll();

    Language update(Language language) throws LanguageNotFound;

    Language findById(long id) throws LanguageNotFound;
}
