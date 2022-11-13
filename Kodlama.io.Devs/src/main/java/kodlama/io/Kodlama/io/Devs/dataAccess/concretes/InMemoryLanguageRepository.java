package kodlama.io.Kodlama.io.Devs.dataAccess.concretes;

import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.Kodlama.io.Devs.entities.concretes.Language;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryLanguageRepository implements LanguageRepository {

    List<Language> languages;

    public InMemoryLanguageRepository() {
        languages = new ArrayList<Language>();
        languages.add(new Language(1, "Java"));
        languages.add(new Language(2, "C#"));
        languages.add(new Language(3, "Python"));

    }

    @Override
    public List<Language> getAll() {
        return languages;
    }

    @Override
    public void add() {
        languages.add(new Language());
    }

    @Override
    public void update() {
    languages.remove(getById());
    }

    @Override
    public void delete(int id) {
    languages.remove(id);
    }


    @Override
    public Language getById() {

        Language returnLangue = null ;
        for(Language arrayLangues : languages)
        {
            if(arrayLangues.getId() == getById().getId())
            {
                returnLangue =  arrayLangues;
            }
        }
        return returnLangue;

    }
}
