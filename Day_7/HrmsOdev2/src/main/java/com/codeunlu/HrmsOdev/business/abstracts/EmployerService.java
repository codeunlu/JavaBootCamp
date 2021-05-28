package com.codeunlu.HrmsOdev.business.abstracts;

import com.codeunlu.HrmsOdev.core.utilities.results.DataResult;
import com.codeunlu.HrmsOdev.core.utilities.results.Result;
import com.codeunlu.HrmsOdev.entities.concretes.Employer;

import java.util.List;

public interface EmployerService {
    DataResult<List<Employer>> get();
    Result add(Employer employer);
}
