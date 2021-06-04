package com.codeunlu.HrmsFinal.business.concretes;

import com.codeunlu.HrmsFinal.business.abstracts.CandidateSkillService;
import com.codeunlu.HrmsFinal.core.utilies.results.Result;
import com.codeunlu.HrmsFinal.core.utilies.results.SuccessResult;
import com.codeunlu.HrmsFinal.dataAccess.abstracts.CandidateSkillDao;
import com.codeunlu.HrmsFinal.entities.concretes.CandidateSkill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateSkillManager implements CandidateSkillService {
    private CandidateSkillDao candidateSkillDao;

    @Autowired
    public CandidateSkillManager(CandidateSkillDao candidateSkillDao){
        this.candidateSkillDao = candidateSkillDao;
    }
    @Override
    public Result add(CandidateSkill candidateSkill) {
        candidateSkillDao.save(candidateSkill);
        return new SuccessResult("Registered is Candidate Skills");
    }
}
