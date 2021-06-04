package com.codeunlu.HrmsFinal.business.concretes;

import com.codeunlu.HrmsFinal.business.abstracts.CandidateSocialService;
import com.codeunlu.HrmsFinal.core.utilies.results.Result;
import com.codeunlu.HrmsFinal.core.utilies.results.SuccessResult;
import com.codeunlu.HrmsFinal.dataAccess.abstracts.CandidateSocialDao;
import com.codeunlu.HrmsFinal.entities.concretes.CandidateSocial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateSocialManager implements CandidateSocialService {
    private CandidateSocialDao candidateSocialDao;
    @Autowired
    public CandidateSocialManager(CandidateSocialDao candidateSocialDao){
        this.candidateSocialDao = candidateSocialDao;
    }
    @Override
    public Result add(CandidateSocial candidateSocial) {
        candidateSocialDao.save(candidateSocial);
        return new SuccessResult("Registered is Candidate Socials");
    }
}
