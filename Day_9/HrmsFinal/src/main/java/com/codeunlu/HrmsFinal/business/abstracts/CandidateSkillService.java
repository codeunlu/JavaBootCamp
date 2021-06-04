package com.codeunlu.HrmsFinal.business.abstracts;

import com.codeunlu.HrmsFinal.core.utilies.results.Result;
import com.codeunlu.HrmsFinal.entities.concretes.CandidateSkill;

public interface CandidateSkillService {
    Result add(CandidateSkill candidateSkill);
}
