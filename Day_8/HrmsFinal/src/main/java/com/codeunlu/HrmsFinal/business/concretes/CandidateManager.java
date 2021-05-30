package com.codeunlu.HrmsFinal.business.concretes;
import com.codeunlu.HrmsFinal.business.abstracts.CandidateService;
import com.codeunlu.HrmsFinal.business.abstracts.VerifactionService;
import com.codeunlu.HrmsFinal.core.adapters.mernis.MernisService;
import com.codeunlu.HrmsFinal.core.utilies.results.*;
import com.codeunlu.HrmsFinal.dataAccess.abstracts.CandidateDao;
import com.codeunlu.HrmsFinal.entities.concretes.Candidate;
import com.codeunlu.HrmsFinal.entities.concretes.Verifaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateManager implements CandidateService {
    private CandidateDao candidateDao;
    private VerifactionService verifactionService;
    private MernisService mernisService;
    @Autowired
    public CandidateManager(
            CandidateDao candidateDao,
            VerifactionService verifactionService,
            MernisService mernisService){
        this.candidateDao = candidateDao;
        this.verifactionService = verifactionService;
        this.mernisService = mernisService;
    }
    @Override
    public Result add(Candidate candidate) {
        if(candidate.getName().isEmpty()
                || candidate.getNationalId().isEmpty()
                || candidate.getSurname().isEmpty()
                || candidate.getEmail().isEmpty()
                || candidate.getPassword().isEmpty()
                || candidate.getPasswordVerify().isEmpty()
                || candidate.getDateofBirth().toString().isEmpty()
                || candidate.getNationalId().length() != 11
        ){
            return new ErrorResult("You left empty space.");
        }else if(!candidate.getPassword().equals(candidate.getPasswordVerify())){
            return new ErrorResult("Passwords do not match.");
        }else if(
                !mernisService.verifyUser(
                        candidate.getDateofBirth().getYear(),
                        candidate.getName(),
                        candidate.getSurname())
        ){
            return new ErrorResult("The person is not real!");
        }else if(candidateDao.findByEmail(candidate.getEmail()) != null){
            return new ErrorResult("Email address is used!");
        }else if(candidateDao.findByNationalId(candidate.getNationalId()) != null){
            return new ErrorResult("National id is used!");
        }
        candidateDao.save(candidate);
        verifactionService.add(candidate.getId(), candidate.getEmail(), new Verifaction());
        return new SuccessResult("You have successfully registered.");

    }
    @Override
    public DataResult<List<Candidate>> getAll() {
        return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(),"All Candidates Listed!");
    }
}
