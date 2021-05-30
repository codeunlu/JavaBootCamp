package com.codeunlu.HrmsFinal.business.concretes;

import com.codeunlu.HrmsFinal.business.abstracts.JobAdvertService;
import com.codeunlu.HrmsFinal.core.utilies.results.*;
import com.codeunlu.HrmsFinal.dataAccess.abstracts.JobAdvertDao;
import com.codeunlu.HrmsFinal.entities.concretes.JobAdvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobAdvertManager implements JobAdvertService {

    private JobAdvertDao jobAdvertDao;
    @Autowired
    public JobAdvertManager(
            JobAdvertDao jobAdvertDao
    ){
        this.jobAdvertDao = jobAdvertDao;
    }

    @Override
    public Result add(JobAdvert jobAdvert) {
        if(jobAdvert.getJobPositions() == null){
            return new ErrorResult("Job Position is not null!");
        }else if(jobAdvert.getDescription() == null){
            return new ErrorResult("Description is not null!");
        }else if(jobAdvert.getJobCities() == null){
            return new ErrorResult("Job city is not null!");
        }else if(jobAdvert.getQuantity() <= 0){
            return new ErrorResult("Quantity is not null!");
        }
        this.jobAdvertDao.save(jobAdvert);
        return new SuccessResult("The job posting has been successfully added.");
    }

    @Override
    public DataResult<List<JobAdvert>> getByActiveTrue() {
        return new SuccessDataResult<List<JobAdvert>>(
                this.jobAdvertDao.getByActiveTrue(),
                "Active job postings are listed."
        );
    }

    @Override
    public DataResult<List<JobAdvert>> getByReleaseDateDesc() {
        return new SuccessDataResult<List<JobAdvert>>(
                this.jobAdvertDao.getByReleaseDateDesc(),
                "Job postings are sorted from the new date."
        );
    }

    @Override
    public DataResult<List<JobAdvert>> getByReleaseDateAsc() {
        return new SuccessDataResult<List<JobAdvert>>(
                this.jobAdvertDao.getByReleaseDateAsc(),
                "Job postings are sorted from the old date."
        );
    }

    @Override
    public DataResult<List<JobAdvert>> getByEmployersId(int id) {
        return new SuccessDataResult<List<JobAdvert>>(
                this.jobAdvertDao.getByEmployersId(id),
                "The company's postings are listed."
        );
    }


}
