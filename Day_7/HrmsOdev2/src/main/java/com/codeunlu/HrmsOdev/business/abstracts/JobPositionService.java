package com.codeunlu.HrmsOdev.business.abstracts;

import com.codeunlu.HrmsOdev.core.utilities.results.DataResult;
import com.codeunlu.HrmsOdev.core.utilities.results.Result;
import com.codeunlu.HrmsOdev.entities.concretes.JobPosition;

import java.util.List;

public interface JobPositionService {
    DataResult<List<JobPosition>> get();
    Result add(JobPosition jobPosition);
}
