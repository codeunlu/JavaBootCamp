package com.codeunlu.HrmsFinal.business.concretes;

import com.codeunlu.HrmsFinal.business.abstracts.CandidateEducationService;
import com.codeunlu.HrmsFinal.core.utilies.results.DataResult;
import com.codeunlu.HrmsFinal.core.utilies.results.Result;
import com.codeunlu.HrmsFinal.core.utilies.results.SuccessDataResult;
import com.codeunlu.HrmsFinal.core.utilies.results.SuccessResult;
import com.codeunlu.HrmsFinal.dataAccess.abstracts.CandidateEducationDao;
import com.codeunlu.HrmsFinal.entities.concretes.CandidateEducation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateEducationManager implements CandidateEducationService {
    private CandidateEducationDao candidateEducationDao;
    @Autowired
    public CandidateEducationManager(CandidateEducationDao candidateEducationDao){
        this.candidateEducationDao = candidateEducationDao;
    }
    @Override
    public Result add(CandidateEducation candidateEducation) {
        candidateEducationDao.save(candidateEducation);
        return new SuccessResult("Registered is Candidate Educations");
    }

    @Override
    public DataResult<List<CandidateEducation>> getCandidateEducationByCandidate_IdOrderByEndYearDesc(int id) {
        return new SuccessDataResult<List<CandidateEducation>>(
                this.candidateEducationDao.getCandidateEducationByCandidate_IdOrderByEndYearDesc(id),
                "Data Listed!"
        );
    }


}
