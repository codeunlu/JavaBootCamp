package com.codeunlu.HrmsOdev.business.concretes;
import com.codeunlu.HrmsOdev.business.abstracts.VerifactionService;
import com.codeunlu.HrmsOdev.core.utilities.results.*;

import com.codeunlu.HrmsOdev.dataAccess.abstracts.CandidateDao;
import com.codeunlu.HrmsOdev.dataAccess.abstracts.EmployerDao;
import com.codeunlu.HrmsOdev.dataAccess.abstracts.VerifactionDao;

import com.codeunlu.HrmsOdev.dataAccess.abstracts.VerifactionPersonDao;
import com.codeunlu.HrmsOdev.entities.concretes.Candidate;
import com.codeunlu.HrmsOdev.entities.concretes.Employer;
import com.codeunlu.HrmsOdev.entities.concretes.Verifaction;
import com.codeunlu.HrmsOdev.entities.concretes.VerifactionPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class VerifactionManager implements VerifactionService {

    private VerifactionDao verifactionDao;
    private CandidateDao candidateDao;
    private EmployerDao employerDao;
    private int user_id;

    @Autowired
    public VerifactionManager(VerifactionDao verifactionDao,CandidateDao candidateDao,EmployerDao employerDao){
        this.verifactionDao = verifactionDao;
        this.candidateDao = candidateDao;
        this.employerDao = employerDao;
    }

    @Override
    public void hasCode(int id) {
        Verifaction verifaction = new Verifaction();
        String createCode = UUID.randomUUID().toString();
        verifaction.setUserId(id);
        verifaction.setActive(true);
        verifaction.setCode(createCode.replace("-",""));
        verifactionDao.save(verifaction);
    }

    @Override
    public Result sendMail(String email) {
        return new SuccessResult(email + " send to mail.");
    }

    @Override
    public Result findAllByCode(String code) {

        List<Verifaction> users = verifactionDao.findAllByCode(code);
        for (Verifaction user:users) {
            user_id = user.getUserId();
            user.setActive(false);
            verifactionDao.save(user);
        }
        if(candidateDao.findAllById(user_id).size() != 0){
            List<Candidate> candidatesField = candidateDao.findAllById(user_id);
            for(Candidate candidates :candidatesField){
                candidates.setVerified(true);
                candidateDao.save(candidates);
                return new SuccessResult("Candidates is verifaction success!");
            }
        }else if(employerDao.findAllById(user_id).size() != 0){
            List<Employer> employersField = employerDao.findAllById(user_id);
            for(Employer employers :employersField){
                employers.setVerified(true);
                employerDao.save(employers);
                return new SuccessResult("Employer is verifaction success!");
            }
        }
        return new ErrorResult("Verifaction is error!");
    }
}
