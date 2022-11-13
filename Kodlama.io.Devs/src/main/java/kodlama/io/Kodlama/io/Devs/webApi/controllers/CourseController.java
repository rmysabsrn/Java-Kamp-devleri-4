package kodlama.io.Kodlama.io.Devs.webApi.controllers;

import kodlama.io.Kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Kodlama.io.Devs.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    private LanguageService languageService;


    @Autowired
    public CourseController(LanguageService languageService) {
        this.languageService = languageService;

    }

    @PostMapping("/add")
    public void add(Language language) throws Exception{
        languageService.create(language);
    }

    @PutMapping("/update")
    public void update(Language language) throws Exception {
        languageService.update(language);
    }

    @DeleteMapping("/delete")
    public void delete (int id) throws Exception {
        languageService.delete(id);
    }

    @GetMapping("/getById")
    public void getById(int id) throws Exception {
        languageService.getById(id);
    }

    @GetMapping("/getall")
    public List<Language> getAll() {
        return languageService.getAll();
    }
}
