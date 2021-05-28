package com.codeunlu.HrmsOdev.business.concretes;

import com.codeunlu.HrmsOdev.business.abstracts.FormCheckService;
import com.codeunlu.HrmsOdev.business.abstracts.JobPositionService;
import com.codeunlu.HrmsOdev.core.utilities.results.DataResult;
import com.codeunlu.HrmsOdev.core.utilities.results.ErrorResult;
import com.codeunlu.HrmsOdev.core.utilities.results.Result;
import com.codeunlu.HrmsOdev.core.utilities.results.SuccessDataResult;
import com.codeunlu.HrmsOdev.dataAccess.abstracts.JobPositionDao;
import com.codeunlu.HrmsOdev.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPositionManager implements JobPositionService {

    private JobPositionDao jobPositionDao;
    private FormCheckService form;

    @Autowired
    public JobPositionManager(JobPositionDao jobPositionDao,FormCheckService form){
        this.jobPositionDao = jobPositionDao;
        this.form = form;
    }

    @Override
    public DataResult<List<JobPosition>> get() {
        return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(),"All Job Position Listed!");
    }

    @Override
    public Result add(JobPosition jobPosition) {
        if(!form.isCheckTitle(jobPosition.getTitle())){
            return new ErrorResult("Title is available");
        }
        return new SuccessDataResult<JobPosition>
                (this.jobPositionDao.save(jobPosition),"Registered is Job Position");
    }
}
