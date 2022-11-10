package kodlama.io.Kodlama.io.Devs.business.abstracts;

import kodlama.io.Kodlama.io.Devs.entities.concretes.Language;

import java.util.List;

public interface LanguageService {
    List<Language> getAll();
    Language getById(int id) throws Exception;
    void create(int id);
    void update(int id,String name);
    void delete();
}
