package com.codeunlu.HrmsFinal.business.concretes;

import com.codeunlu.HrmsFinal.business.abstracts.VerifactionService;
import com.codeunlu.HrmsFinal.core.adapters.emails.EmailSendService;
import com.codeunlu.HrmsFinal.core.utilies.results.ErrorResult;
import com.codeunlu.HrmsFinal.core.utilies.results.Result;
import com.codeunlu.HrmsFinal.core.utilies.results.SuccessResult;
import com.codeunlu.HrmsFinal.dataAccess.abstracts.*;
import com.codeunlu.HrmsFinal.entities.concretes.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VerifactionManager implements VerifactionService {

    private VerifactionDao verifactionDao;
    private VerifactionEmployeeDao verifactionEmployeeDao;
    private EmailSendService emailSendService;
    private CandidateDao candidateDao;
    private EmployerDao employerDao;
    @Autowired
    public VerifactionManager(
            VerifactionDao verifactionDao,
            VerifactionEmployeeDao verifactionEmployeeDao,
            EmailSendService emailSendService,
            CandidateDao candidateDao,
            EmployerDao employerDao
    ){
        this.verifactionDao = verifactionDao;
        this.verifactionEmployeeDao = verifactionEmployeeDao;
        this.employerDao = employerDao;
        this.candidateDao = candidateDao;
        this.emailSendService = emailSendService;
    }
    @Override
    public Result add(int userId,String email,Verifaction verifaction) {
        UUID code = UUID.randomUUID();
        verifaction.setUserId(userId);
        verifaction.setCode(code.toString());
        verifaction.setActive(true);
        verifactionDao.save(verifaction);
        emailSendService.send(email,code.toString());
        return new SuccessResult("Registered is verifaction code.");
    }
    @Override
    public Result active(String code) {
        if(verifactionDao.getByCode(code) != null){
            if(candidateDao.findById(verifactionDao.getByCode(code).getUserId()) != null){
                candidateDao.findById(
                        verifactionDao.getByCode(code).getUserId())
                        .setVerified(true);
                candidateDao.save(
                        candidateDao.findById(verifactionDao.getByCode(code)
                                .getUserId()));
                verifactionDao.getByCode(code).setActive(false);
                verifactionDao.save(verifactionDao.getByCode(code));
                return new SuccessResult("Your account has been confirmed.");
            }else if(employerDao.findById(verifactionDao.getByCode(code).getUserId()) != null){
                employerDao.findById(
                        verifactionDao.getByCode(code).getUserId())
                        .setVerified(true);
                employerDao.save(employerDao.findById(verifactionDao.getByCode(code).getUserId()));
                verifactionDao.getByCode(code).setActive(false);
                verifactionDao.save(verifactionDao.getByCode(code));
                return new SuccessResult("Your account has been confirmed.");
            }
        }
        return new ErrorResult("Confirmation code not found!");
    }
    @Override
    public Result activeEmployee(int userId,int employeeId) {
        if(employerDao.findById(userId) != null){
            employerDao.findById(userId).setVerified(true);
            employerDao.save(employerDao.findById(userId));
            verifactionDao.findByUserId(userId).setActive(false);
            verifactionDao.save(verifactionDao.findByUserId(userId));
            VerifactionEmployee verifactionEmployee = new VerifactionEmployee();
            verifactionEmployee.setUserId(userId);
            verifactionEmployee.setEmployeeId(employeeId);
            verifactionEmployeeDao.save(verifactionEmployee);
            return new SuccessResult("Your account has been confirmed.");
        }
        return new ErrorResult("Employer not found!");
    }
}
