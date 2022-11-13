package kodlama.io.Kodlama.io.Devs.business.concretes.validation;

import kodlama.io.Kodlama.io.Devs.entities.concretes.Language;

import java.util.List;

public class ValidateManager {
    public static  boolean emptyNameCheck(String name)
    {
        boolean returnCheck = false;
        if(name.isEmpty() || name == null)
            returnCheck = true;
        return returnCheck;
    }

    public static  boolean repeatNameCheck(List<Language> langues, String name)
    {

        boolean returnCheck = false;
        for(Language arrayLanguage : langues)
        {
            if(arrayLanguage.getName().contains(name))
                returnCheck = true;
        }
        return returnCheck;
    }

    public static boolean repeatNameCheckUpdate(List<Language> langues,String name, int id)
    {
        boolean returnCheck = false;
        for(Language arrayLanguage : langues)
        {
            if(arrayLanguage.getName().contains(name) && arrayLanguage.getId() != id)
                returnCheck = true;
        }
        return returnCheck;
    }

    public static boolean isLanguage(List<Language> langues, int id)
    {
        boolean returnCheck = false;
        for(Language arrayLanguage : langues)
        {
            if(arrayLanguage.getId() == id)
                returnCheck = true;
        }
        return returnCheck;
    }
}
