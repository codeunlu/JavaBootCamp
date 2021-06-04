package com.codeunlu.HrmsFinal.business.concretes;

import com.codeunlu.HrmsFinal.business.abstracts.LanguageService;
import com.codeunlu.HrmsFinal.core.utilies.results.Result;
import com.codeunlu.HrmsFinal.core.utilies.results.SuccessResult;
import com.codeunlu.HrmsFinal.dataAccess.abstracts.LanguageDao;
import com.codeunlu.HrmsFinal.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LanguageManager implements LanguageService {
    private LanguageDao languageDao;
    @Autowired
    public LanguageManager(LanguageDao languageDao){
        this.languageDao = languageDao;
    }
    @Override
    public Result add(Language language) {
        languageDao.save(language);
        return new SuccessResult("Registered is Languages");
    }
}
