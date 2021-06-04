package com.codeunlu.HrmsFinal.business.concretes;
import com.codeunlu.HrmsFinal.business.abstracts.EmployeeService;
import com.codeunlu.HrmsFinal.core.utilies.results.*;
import com.codeunlu.HrmsFinal.dataAccess.abstracts.EmployeeDao;
import com.codeunlu.HrmsFinal.entities.concretes.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeManager implements EmployeeService {
    private EmployeeDao employeeDao;
    @Autowired
    public EmployeeManager(
            EmployeeDao employeeDao
    ){
        this.employeeDao = employeeDao;
    }
    @Override
    public Result add(Employee employee) {
        if(
                employee.getEmail().isEmpty()
                        || employee.getName().isEmpty()
                        || employee.getSurname().isEmpty()
                        || employee.getPassword().isEmpty()
                        || employee.getPasswordVerify().isEmpty()
        ){
            return new ErrorResult("You left empty space.");
        }
        employeeDao.save(employee);
        return new SuccessResult("You have successfully registered.");
    }

    @Override
    public DataResult<List<Employee>> getAll() {
        return new SuccessDataResult<List<Employee>>(
                this.employeeDao.findAll(),
                "Employees Listed!"
        );
    }
}
