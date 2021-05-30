package com.codeunlu.HrmsFinal.business.concretes;
import com.codeunlu.HrmsFinal.business.abstracts.EmployerService;
import com.codeunlu.HrmsFinal.business.abstracts.VerifactionService;
import com.codeunlu.HrmsFinal.core.utilies.results.*;
import com.codeunlu.HrmsFinal.dataAccess.abstracts.EmployerDao;
import com.codeunlu.HrmsFinal.dataAccess.abstracts.JobAdvertDao;
import com.codeunlu.HrmsFinal.entities.concretes.Employer;
import com.codeunlu.HrmsFinal.entities.concretes.JobAdvert;
import com.codeunlu.HrmsFinal.entities.concretes.Verifaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerManager implements EmployerService {

    private EmployerDao employerDao;
    private VerifactionService verifactionService;
    private JobAdvertDao jobAdvertDao;

    @Autowired
    public EmployerManager(
            EmployerDao employerDao,
            VerifactionService verifactionService,
            JobAdvertDao jobAdvertDao
    ){
        this.employerDao = employerDao;
        this.jobAdvertDao = jobAdvertDao;
        this.verifactionService = verifactionService;
    }
    @Override
    public Result add(Employer employer) {
        if(
                employer.getEmail().isEmpty()
                || employer.getWebURI().isEmpty()
                || employer.getCompanyName().isEmpty()
                || employer.getTelephone().isEmpty()
                || employer.getPassword().isEmpty()
                || employer.getPasswordVerify().isEmpty()
        ){
            return new ErrorResult("You left empty space.");
        }else if(employerDao.findByEmail(employer.getEmail()).size() != 0){
            return new ErrorResult("Email address is used!");
        }else if(!isCompanyEmail(employer.getEmail(),employer.getWebURI())){
            return new ErrorResult("Email and website do not match!");
        }else if(!employer.getPassword().equals(employer.getPasswordVerify())){
            return new ErrorResult("Passwords do not match!");
        }
        employerDao.save(employer);
        verifactionService.add(employer.getId(), employer.getEmail(), new Verifaction());
        return new SuccessResult("You have successfully registered.");
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<List<Employer>>(
                this.employerDao.findAll(),
                "Employer Listed!"
        );
    }

    @Override
    public boolean isCompanyEmail(String email,String webURI){
        String[] cuting = email.split("@");
        return cuting[1].equals(webURI);
    }

    @Override
    public Result passive(int employerId, int id) {
        if(jobAdvertDao.findById(id) != null
                && jobAdvertDao.findByEmployers(employerId) != null){
            jobAdvertDao.findById(id).setActive(false);
            jobAdvertDao.save(jobAdvertDao.findById(id));
            return new SuccessResult("Your post has been deactivated.");
        }
        return new ErrorResult("The information entered is incorrect.");
    }

}
