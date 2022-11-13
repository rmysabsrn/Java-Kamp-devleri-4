package kodlama.io.Kodlama.io.Devs.business.concretes;

import kodlama.io.Kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Kodlama.io.Devs.business.concretes.validation.ValidateManager;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.Kodlama.io.Devs.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageManager implements LanguageService {
   private LanguageRepository languageRepository;

    @Autowired
    public LanguageManager(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public List<Language> getAll() {
     List<Language> returnList = languageRepository.getAll();
     if(returnList != null)
      System.out.println("Programlama dili listesi getirildi.");
     else
      System.out.println("Programlama dili listesi getirilemedi , başarısız!");
        return languageRepository.getAll();
    }

    @Override
    public Language getById(int id) throws Exception {
     return languageRepository.getById();
    }

    @Override
    public void create(Language language) {
     if(ValidateManager.emptyNameCheck(language.getName())){
      System.out.println("Programlama dilinin adı boş olamaz, kayıt başarısız!");
     } else if (ValidateManager.repeatNameCheck(getAll(), language.getName())) {
      System.out.println("["+language.getName()+"] ,programlama dili listede mevcut, ekleme başarısız!");
     }
     else
     {
      languageRepository.create();
      System.out.println("["+language.getName()+"] , adlı programlama dili eklendi!");
     }
    }

    @Override
    public void update(Language language) {

     if(ValidateManager.emptyNameCheck(language.getName()))
     {
      System.out.println("Programlama dilinin adı boş olamaz, güncelleme başarısız!");
     }

     else if(!ValidateManager.isLanguage(getAll(),language.getId()))
     {
      System.out.println("["+language.getName()+ "] , adlı kayıt bulunamadı, güncelleme başarısız!");
     }

     else if( ValidateManager.repeatNameCheckUpdate(getAll(),  language.getName(), language.getId() ) )
     {
      System.out.println("["+language.getName()+ "] ,programlama dili listede mevcut, güncelleme başarısız!");
     }

     else
     {
      languageRepository.update();
      System.out.println("["+language.getName()+"] ,programlama dili güncellendi!");
     }
    }

    @Override
    public void delete(int id) {
     if(!ValidateManager.isLanguage(getAll(),id))
     {
      System.out.println("["+id+ "] , numaralı kayıt zaten yok, silme işlemi başarısız");
     }
     else
     {
      languageRepository.delete(id);
      System.out.println(": numaralı programlama dili silindi");
     }
    }
}
