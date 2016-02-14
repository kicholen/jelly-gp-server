package jelly.repository.language;

import jelly.entity.language.Language;
import jelly.repository.AbstractRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LanguageRepositoryImpl extends AbstractRepository<Language> implements LanguageRepository {

    public LanguageRepositoryImpl() {
        super();
        setClazz(Language.class);
    }

    @Override
    public List<Language> findAll() {
        return query(Language.FIND_ALL);
    }
}
