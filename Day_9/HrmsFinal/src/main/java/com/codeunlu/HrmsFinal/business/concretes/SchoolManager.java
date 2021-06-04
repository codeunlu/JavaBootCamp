package com.codeunlu.HrmsFinal.business.concretes;

import com.codeunlu.HrmsFinal.business.abstracts.SchoolService;
import com.codeunlu.HrmsFinal.core.utilies.results.Result;
import com.codeunlu.HrmsFinal.core.utilies.results.SuccessResult;
import com.codeunlu.HrmsFinal.dataAccess.abstracts.SchoolDao;
import com.codeunlu.HrmsFinal.entities.concretes.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchoolManager implements SchoolService {

    private SchoolDao schoolDao;
    @Autowired
    public SchoolManager(SchoolDao schoolDao){
        this.schoolDao = schoolDao;
    }
    @Override
    public Result add(School school) {
        schoolDao.save(school);
        return new SuccessResult("Registered is School");
    }
}
