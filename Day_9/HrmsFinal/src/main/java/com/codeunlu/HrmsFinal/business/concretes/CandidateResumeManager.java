package com.codeunlu.HrmsFinal.business.concretes;

import com.codeunlu.HrmsFinal.business.abstracts.CandidateResumeService;
import com.codeunlu.HrmsFinal.core.utilies.results.Result;
import com.codeunlu.HrmsFinal.core.utilies.results.SuccessResult;
import com.codeunlu.HrmsFinal.dataAccess.abstracts.CandidateResumeDao;
import com.codeunlu.HrmsFinal.entities.concretes.CandidateResume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateResumeManager implements CandidateResumeService {
    private CandidateResumeDao candidateResumeDao;
    @Autowired
    public CandidateResumeManager(CandidateResumeDao candidateResumeDao){
        this.candidateResumeDao = candidateResumeDao;
    }
    @Override
    public Result add(CandidateResume candidateResume) {
        candidateResumeDao.save(candidateResume);
        return new SuccessResult("Registered is Candidate Resume");
    }

}
