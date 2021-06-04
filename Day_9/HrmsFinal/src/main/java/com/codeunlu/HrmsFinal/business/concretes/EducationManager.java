package com.codeunlu.HrmsFinal.business.concretes;

import com.codeunlu.HrmsFinal.business.abstracts.EducationService;
import com.codeunlu.HrmsFinal.core.utilies.results.Result;
import com.codeunlu.HrmsFinal.core.utilies.results.SuccessResult;
import com.codeunlu.HrmsFinal.dataAccess.abstracts.EducationDao;
import com.codeunlu.HrmsFinal.entities.concretes.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationManager implements EducationService {

    private EducationDao educationDao;
    @Autowired
    public EducationManager(EducationDao educationDao){
        this.educationDao = educationDao;
    }
    @Override
    public Result add(Education education) {
        educationDao.save(education);
        return new SuccessResult("Registered is Educations");
    }
}
