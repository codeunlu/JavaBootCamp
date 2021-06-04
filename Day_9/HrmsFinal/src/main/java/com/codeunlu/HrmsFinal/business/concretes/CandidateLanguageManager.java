package com.codeunlu.HrmsFinal.business.concretes;

import com.codeunlu.HrmsFinal.business.abstracts.CandidateLanguageService;
import com.codeunlu.HrmsFinal.core.utilies.results.Result;
import com.codeunlu.HrmsFinal.core.utilies.results.SuccessResult;
import com.codeunlu.HrmsFinal.dataAccess.abstracts.CandidateLanguageDao;
import com.codeunlu.HrmsFinal.entities.concretes.CandidateLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateLanguageManager implements CandidateLanguageService {
    private CandidateLanguageDao candidateLanguageDao;
    @Autowired
    public CandidateLanguageManager(CandidateLanguageDao candidateLanguageDao){
        this.candidateLanguageDao = candidateLanguageDao;
    }
    @Override
    public Result add(CandidateLanguage candidateLanguage) {
        candidateLanguageDao.save(candidateLanguage);
        return new SuccessResult("Registered is Candidate Languages");
    }
}
