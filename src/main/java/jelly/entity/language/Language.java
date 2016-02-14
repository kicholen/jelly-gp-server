package jelly.entity.language;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;

@Entity
@NamedQueries({@NamedQuery(name = Language.FIND_ALL, query = "SELECT c FROM Language c"),
        @NamedQuery(name = Language.DELETE_ALL, query = "DELETE FROM Language c")})
public class Language implements Serializable {
    public final static String FIND_ALL = "Language.findAll";
    public final static String DELETE_ALL = "Language.deleteAll";

    @Id
    @GeneratedValue
    long id;
    String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<LanguageTranslation> translations = new ArrayList<LanguageTranslation>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<LanguageTranslation> getTranslations() {
        return translations;
    }

    public void setTranslations(List<LanguageTranslation> translations) {
        this.translations = translations;
    }
}
