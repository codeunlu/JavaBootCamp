package com.codeunlu.HrmsFinal.business.abstracts;

import com.codeunlu.HrmsFinal.core.utilies.results.DataResult;
import com.codeunlu.HrmsFinal.core.utilies.results.Result;
import com.codeunlu.HrmsFinal.entities.concretes.JobAdvert;
import com.codeunlu.HrmsFinal.entities.dto.JobAdvertDto;

import java.util.List;

public interface JobAdvertService {
    Result add(JobAdvert jobAdvert);
    DataResult<List<JobAdvertDto>> getActiveAdverts();
    DataResult<List<JobAdvertDto>> getActiveAdvertsDesc();
    DataResult<List<JobAdvertDto>> getActiveAdvertsAsc();
    DataResult<List<JobAdvertDto>> getActiveAdvertsEmployer(int id);



}
