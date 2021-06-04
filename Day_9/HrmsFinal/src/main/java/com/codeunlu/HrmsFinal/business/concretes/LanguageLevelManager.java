package com.codeunlu.HrmsFinal.business.concretes;

import com.codeunlu.HrmsFinal.business.abstracts.LanguageLevelService;
import com.codeunlu.HrmsFinal.core.utilies.results.Result;
import com.codeunlu.HrmsFinal.core.utilies.results.SuccessResult;
import com.codeunlu.HrmsFinal.dataAccess.abstracts.LanguageLevelDao;
import com.codeunlu.HrmsFinal.entities.concretes.LanguageLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LanguageLevelManager implements LanguageLevelService {
    private LanguageLevelDao languageLevelDao;
    @Autowired
    public LanguageLevelManager(LanguageLevelDao languageLevelDao){
        this.languageLevelDao = languageLevelDao;
    }
    @Override
    public Result add(LanguageLevel languageLevel) {
        languageLevelDao.save(languageLevel);
        return new SuccessResult("Registered is Language Leves");
    }
}
