package com.codeunlu.HrmsOdev.business.concretes;

import com.codeunlu.HrmsOdev.business.abstracts.FormCheckService;
import com.codeunlu.HrmsOdev.business.abstracts.CandidateService;
import com.codeunlu.HrmsOdev.business.abstracts.VerifactionService;
import com.codeunlu.HrmsOdev.core.utilities.results.*;
import com.codeunlu.HrmsOdev.dataAccess.abstracts.CandidateDao;
import com.codeunlu.HrmsOdev.dataAccess.abstracts.VerifactionDao;
import com.codeunlu.HrmsOdev.entities.concretes.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateManager implements CandidateService {

    private CandidateDao candidateDao;
    private VerifactionService verifactionService;
    private FormCheckService form;

    @Autowired
    public CandidateManager(CandidateDao candidateDao,VerifactionService verifactionService, FormCheckService formCheckService){
        this.candidateDao = candidateDao;
        this.verifactionService = verifactionService;
        this.form = formCheckService;
    }

    @Override
    public DataResult<List<Candidate>> get() {
        return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(),"All Candidate Listed!");
    }

    @Override
    public Result add(Candidate candidate) {
        if(!form.isCheckEmail(candidate.getEmail())){
            return new ErrorResult("This email is used.");
        }else if(!form.isCheckPassword(candidate)){
            return new ErrorResult("Passwords do not match.");
        }else if(!form.isCheckNationalId(candidate.getNationalId())){
            return new ErrorResult("This national id is used.");
        }else if(!form.isCheckInput(candidate.getName())){
            return new ErrorResult("Name is wrong.");
        }else if(!form.isCheckInput(candidate.getSurname())){
            return new ErrorResult("Surname is wrong.");
        }else if(!form.isCheckMernis(candidate.getNationalId(), candidate.getName(), candidate.getSurname(),candidate.getDateYear())){
            return new ErrorResult("Mernis is alert.");
        }
        this.candidateDao.save(candidate);
        this.verifactionService.hasCode(candidate.getId());
        this.verifactionService.sendMail(candidate.getEmail());
        return new SuccessResult("Register is completed.");
    }
}
