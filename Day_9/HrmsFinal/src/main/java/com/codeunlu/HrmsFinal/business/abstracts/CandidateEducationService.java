package com.codeunlu.HrmsFinal.business.abstracts;

import com.codeunlu.HrmsFinal.core.utilies.results.DataResult;
import com.codeunlu.HrmsFinal.core.utilies.results.Result;
import com.codeunlu.HrmsFinal.entities.concretes.CandidateEducation;

import java.util.List;

public interface CandidateEducationService {
    Result add(CandidateEducation candidateEducation);
    DataResult<List<CandidateEducation>> getCandidateEducationByCandidate_IdOrderByEndYearDesc(int id);
}
