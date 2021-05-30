package com.codeunlu.HrmsFinal.business.concretes;

import com.codeunlu.HrmsFinal.business.abstracts.JobPositionService;
import com.codeunlu.HrmsFinal.core.utilies.results.*;
import com.codeunlu.HrmsFinal.dataAccess.abstracts.JobPositionDao;
import com.codeunlu.HrmsFinal.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPositionManager implements JobPositionService {
    private JobPositionDao jobPositionDao;
    @Autowired
    public JobPositionManager(
            JobPositionDao jobPositionDao
    ){
        this.jobPositionDao = jobPositionDao;
    }
    @Override
    public Result add(JobPosition jobPosition) {
        if(jobPositionDao.findByTitle(jobPosition.getTitle()).size() != 0){
            return new ErrorResult("This position is available!");
        }
        jobPositionDao.save(jobPosition);
        return new SuccessResult("The position has been successfully created.");
    }

    @Override
    public DataResult<List<JobPosition>> getAll() {
        return new SuccessDataResult(
                this.jobPositionDao.findAll(),
                "Job Position Listed!"
        );
    }
}
