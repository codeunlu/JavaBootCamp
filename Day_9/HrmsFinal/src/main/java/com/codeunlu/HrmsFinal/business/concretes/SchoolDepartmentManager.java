package com.codeunlu.HrmsFinal.business.concretes;

import com.codeunlu.HrmsFinal.business.abstracts.SchoolDepartmentService;
import com.codeunlu.HrmsFinal.core.utilies.results.Result;
import com.codeunlu.HrmsFinal.core.utilies.results.SuccessResult;
import com.codeunlu.HrmsFinal.dataAccess.abstracts.SchoolDepartmentDao;
import com.codeunlu.HrmsFinal.entities.concretes.SchoolDepartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchoolDepartmentManager implements SchoolDepartmentService {
    private SchoolDepartmentDao schoolDepartmentDao;
    @Autowired
    public SchoolDepartmentManager(SchoolDepartmentDao schoolDepartmentDao){
        this.schoolDepartmentDao = schoolDepartmentDao;
    }
    @Override
    public Result add(SchoolDepartment schoolDepartment) {
        schoolDepartmentDao.save(schoolDepartment);
        return new SuccessResult("Registered is School Department");
    }
}
