package com.codeunlu.HrmsFinal.business.abstracts;

import com.codeunlu.HrmsFinal.core.utilies.results.DataResult;
import com.codeunlu.HrmsFinal.core.utilies.results.Result;
import com.codeunlu.HrmsFinal.entities.concretes.JobPosition;

import java.util.List;

public interface JobPositionService {
    Result add(JobPosition jobPosition);
    DataResult<List<JobPosition>> getAll();
}
