package com.codeunlu.HrmsOdev.business.concretes;

import com.codeunlu.HrmsOdev.business.abstracts.VerifactionPersonService;
import com.codeunlu.HrmsOdev.core.utilities.results.ErrorResult;
import com.codeunlu.HrmsOdev.core.utilities.results.Result;
import com.codeunlu.HrmsOdev.core.utilities.results.SuccessResult;
import com.codeunlu.HrmsOdev.dataAccess.abstracts.EmployerDao;
import com.codeunlu.HrmsOdev.dataAccess.abstracts.VerifactionDao;
import com.codeunlu.HrmsOdev.dataAccess.abstracts.VerifactionPersonDao;
import com.codeunlu.HrmsOdev.entities.concretes.Employer;
import com.codeunlu.HrmsOdev.entities.concretes.Verifaction;
import com.codeunlu.HrmsOdev.entities.concretes.VerifactionPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VerifactionPersonManager implements VerifactionPersonService {

    private EmployerDao employerDao;
    private VerifactionDao verifactionDao;
    private VerifactionPersonDao verifactionPersonDao;

    @Autowired
    public VerifactionPersonManager(EmployerDao employerDao,VerifactionDao verifactionDao,VerifactionPersonDao verifactionPersonDao){
        this.employerDao = employerDao;
        this.verifactionDao = verifactionDao;
        this.verifactionPersonDao = verifactionPersonDao;
    }

    @Override
    public Result verifyPerson(int personId, int userId) {
        if(employerDao.findAllById(userId).size() != 0){
            List<Employer> employers = employerDao.findAllById(userId);
            List<Verifaction> verifactions = verifactionDao.findAllByUserId(userId);
            for (Employer employer:employers) {
                employer.setVerified(true);
                employerDao.save(employer);
            }
            for(Verifaction verifaction:verifactions){
                verifaction.setActive(false);
                verifactionDao.save(verifaction);
            }

            VerifactionPerson verifactionPerson = new VerifactionPerson();
            verifactionPerson.setPersonId(personId);
            verifactionPerson.setUserId(userId);
            verifactionPersonDao.save(verifactionPerson);
            return new SuccessResult("Employer is verify!");
        }
        return new ErrorResult("Employer is not verify for Person");
    }
}
