package com.codeunlu.HrmsFinal.business.concretes;

import com.codeunlu.HrmsFinal.business.abstracts.CandidateExperienceService;
import com.codeunlu.HrmsFinal.core.utilies.results.DataResult;
import com.codeunlu.HrmsFinal.core.utilies.results.Result;
import com.codeunlu.HrmsFinal.core.utilies.results.SuccessDataResult;
import com.codeunlu.HrmsFinal.core.utilies.results.SuccessResult;
import com.codeunlu.HrmsFinal.dataAccess.abstracts.CandidateExperienceDao;
import com.codeunlu.HrmsFinal.entities.concretes.CandidateExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateExperienceManager implements CandidateExperienceService {
    private CandidateExperienceDao candidateExperienceDao;
    @Autowired
    public CandidateExperienceManager(CandidateExperienceDao candidateExperienceDao){
        this.candidateExperienceDao = candidateExperienceDao;
    }
    @Override
    public Result add(CandidateExperience candidateExperience) {
        candidateExperienceDao.save(candidateExperience);
        return new SuccessResult("Registered is Candidate Experiences");
    }

    @Override
    public DataResult<List<CandidateExperience>> getCandidateExperienceByCandidate_IdOrderByEndYearDesc(int id) {
        return new SuccessDataResult<List<CandidateExperience>>(
                candidateExperienceDao.getCandidateExperienceByCandidate_IdOrderByEndYearDesc(id),
                "Data Listed!"
        );
    }
}
