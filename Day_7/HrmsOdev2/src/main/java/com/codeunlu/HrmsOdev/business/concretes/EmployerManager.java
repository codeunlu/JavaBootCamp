package com.codeunlu.HrmsOdev.business.concretes;

import com.codeunlu.HrmsOdev.business.abstracts.EmployerService;
import com.codeunlu.HrmsOdev.business.abstracts.FormCheckService;
import com.codeunlu.HrmsOdev.business.abstracts.VerifactionService;
import com.codeunlu.HrmsOdev.core.utilities.results.*;
import com.codeunlu.HrmsOdev.dataAccess.abstracts.EmployerDao;
import com.codeunlu.HrmsOdev.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerManager implements EmployerService {

    private EmployerDao employerDao;
    private FormCheckService formCheckService;
    private VerifactionService verifactionService;

    @Autowired
    public EmployerManager(EmployerDao employerDao,FormCheckService formCheckService,VerifactionService verifactionService){
        this.employerDao = employerDao;
        this.verifactionService = verifactionService;
        this.formCheckService = formCheckService;
    }

    @Override
    public DataResult<List<Employer>> get() {
        return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"All Employer Listed!");
    }

    @Override
    public Result add(Employer employer) {
        if(!this.formCheckService.isCheckInput(employer.getCompanyName())){
            return new ErrorResult("Company name cannot be blank");
        }else if(!formCheckService.isCheckEmployerEmail(employer.getEmail())){
            return new ErrorResult("This email is used.");
        }else if(!formCheckService.isCheckCompanyEmail(employer)){
            return new ErrorResult("This email is match.");
        }else if(!formCheckService.isCheckInput(employer.getTelephone())){
            return new ErrorResult("Telephone cannot be blank");
        }else if(!formCheckService.isCheckInput(employer.getWebSite())){
            return new ErrorResult("Web site cannot be blank");
        }else if(!formCheckService.isCheckPassword(employer)){
            return new ErrorResult("Passwords do not match.");
        }
        this.employerDao.save(employer);
        System.out.println(employer.getEmail()+"bbbb");
        this.verifactionService.hasCode(employer.getId());
        this.verifactionService.sendMail(employer.getEmail());
        return new SuccessResult("Register is completed.");
    }
}
