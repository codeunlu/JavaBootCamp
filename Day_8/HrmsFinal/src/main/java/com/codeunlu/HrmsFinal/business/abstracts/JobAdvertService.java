package com.codeunlu.HrmsFinal.business.abstracts;

import com.codeunlu.HrmsFinal.core.utilies.results.DataResult;
import com.codeunlu.HrmsFinal.core.utilies.results.Result;
import com.codeunlu.HrmsFinal.entities.concretes.JobAdvert;

import java.util.List;

public interface JobAdvertService {
    Result add(JobAdvert jobAdvert);
    DataResult<List<JobAdvert>> getByActiveTrue();
    DataResult<List<JobAdvert>> getByReleaseDateDesc();
    DataResult<List<JobAdvert>> getByReleaseDateAsc();
    DataResult<List<JobAdvert>> getByEmployersId(int id);



}
