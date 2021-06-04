package com.codeunlu.HrmsFinal.business.abstracts;

import com.codeunlu.HrmsFinal.core.utilies.results.Result;
import com.codeunlu.HrmsFinal.entities.concretes.SchoolDepartment;

public interface SchoolDepartmentService {
    Result add(SchoolDepartment schoolDepartment);
}
