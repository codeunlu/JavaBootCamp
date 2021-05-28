package com.codeunlu.HrmsOdev.business.abstracts;

import com.codeunlu.HrmsOdev.core.utilities.results.DataResult;
import com.codeunlu.HrmsOdev.core.utilities.results.Result;
import com.codeunlu.HrmsOdev.entities.concretes.Candidate;

import java.util.List;

public interface CandidateService {
    DataResult<List<Candidate>> get();
    Result add(Candidate candidate);
}
