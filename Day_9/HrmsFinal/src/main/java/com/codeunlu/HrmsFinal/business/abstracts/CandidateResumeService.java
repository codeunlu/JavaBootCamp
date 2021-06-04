package com.codeunlu.HrmsFinal.business.abstracts;

import com.codeunlu.HrmsFinal.core.utilies.results.Result;
import com.codeunlu.HrmsFinal.entities.concretes.CandidateResume;

public interface CandidateResumeService {
    Result add(CandidateResume candidateResume);
}
