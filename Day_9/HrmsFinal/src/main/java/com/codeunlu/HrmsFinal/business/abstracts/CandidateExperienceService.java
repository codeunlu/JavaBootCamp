package com.codeunlu.HrmsFinal.business.abstracts;

import com.codeunlu.HrmsFinal.core.utilies.results.DataResult;
import com.codeunlu.HrmsFinal.core.utilies.results.Result;
import com.codeunlu.HrmsFinal.entities.concretes.CandidateExperience;

import java.util.List;

public interface CandidateExperienceService {
    Result add(CandidateExperience candidateExperience);
    DataResult<List<CandidateExperience>> getCandidateExperienceByCandidate_IdOrderByEndYearDesc(int id);
}
