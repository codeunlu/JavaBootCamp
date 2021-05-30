package com.codeunlu.HrmsFinal.business.abstracts;

import com.codeunlu.HrmsFinal.core.utilies.results.DataResult;
import com.codeunlu.HrmsFinal.core.utilies.results.Result;
import com.codeunlu.HrmsFinal.entities.concretes.Employee;

import java.util.List;

public interface EmployeeService {
    Result add(Employee employee);
    DataResult<List<Employee>> getAll();

}
