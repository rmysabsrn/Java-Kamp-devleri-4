package kodlama.io.Kodlama.io.Devs.dataAccess.abstracts;

import kodlama.io.Kodlama.io.Devs.entities.concretes.Language;

import java.util.List;


public interface LanguageRepository {
  List<Language> getAll();
  void add();
  void update();
  void delete(int id);
  Language getById();

}
