package com.codeunlu.HrmsFinal.business.abstracts;

import com.codeunlu.HrmsFinal.core.utilies.results.DataResult;
import com.codeunlu.HrmsFinal.core.utilies.results.Result;
import com.codeunlu.HrmsFinal.entities.concretes.Employer;

import java.util.List;

public interface EmployerService {
    Result add(Employer employer);
    DataResult<List<Employer>> getAll();
    boolean isCompanyEmail(String email,String webURI);
    Result passive(int employerId,int id);

}
