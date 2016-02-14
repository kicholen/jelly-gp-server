package jelly.repository.language;

import jelly.entity.language.Language;

import java.util.List;

public interface LanguageRepository {
    Language findOne(long id);

    List<Language> findAll();

    void create(Language entity);

    Language update(Language entity);

    void delete(long entityId);
}
