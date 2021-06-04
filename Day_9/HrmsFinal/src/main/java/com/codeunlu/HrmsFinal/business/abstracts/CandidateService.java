package com.codeunlu.HrmsFinal.business.abstracts;

import com.codeunlu.HrmsFinal.core.utilies.results.DataResult;
import com.codeunlu.HrmsFinal.core.utilies.results.Result;
import com.codeunlu.HrmsFinal.entities.concretes.Candidate;

import java.util.List;

public interface CandidateService {
    Result add(Candidate candidate);
    DataResult<List<Candidate>> getAll();

}
