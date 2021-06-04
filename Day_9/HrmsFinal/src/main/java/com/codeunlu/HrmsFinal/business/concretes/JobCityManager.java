package com.codeunlu.HrmsFinal.business.concretes;

import com.codeunlu.HrmsFinal.business.abstracts.JobCityService;
import com.codeunlu.HrmsFinal.core.utilies.results.ErrorResult;
import com.codeunlu.HrmsFinal.core.utilies.results.Result;
import com.codeunlu.HrmsFinal.core.utilies.results.SuccessResult;
import com.codeunlu.HrmsFinal.dataAccess.abstracts.JobCityDao;
import com.codeunlu.HrmsFinal.entities.concretes.JobCity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobCityManager implements JobCityService {
    private JobCityDao jobCityDao;
    @Autowired
    public JobCityManager(
            JobCityDao jobCityDao
    ){
        this.jobCityDao = jobCityDao;
    }
    @Override
    public Result add(JobCity jobCity) {
        if(jobCity.getName().isEmpty()){
            return new ErrorResult("City is not null");
        }
        jobCityDao.save(jobCity);
        return new SuccessResult("City is added.");
    }
}
