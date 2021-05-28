package com.codeunlu.HrmsOdev.business.concretes;

import com.codeunlu.HrmsOdev.business.abstracts.FormCheckService;
import com.codeunlu.HrmsOdev.core.utilities.adapters.FakeMernisService;
import com.codeunlu.HrmsOdev.dataAccess.abstracts.CandidateDao;
import com.codeunlu.HrmsOdev.dataAccess.abstracts.EmployerDao;
import com.codeunlu.HrmsOdev.dataAccess.abstracts.JobPositionDao;
import com.codeunlu.HrmsOdev.dataAccess.abstracts.PersonDao;
import com.codeunlu.HrmsOdev.entities.concretes.Employer;
import com.codeunlu.HrmsOdev.entities.concretes.JobPosition;
import com.codeunlu.HrmsOdev.entities.concretes.Person;
import com.codeunlu.HrmsOdev.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormCheckManager implements FormCheckService {

    private CandidateDao candidateDao;
    private EmployerDao employerDao;
    private PersonDao personDao;
    private FakeMernisService fakeMernisService;
    private JobPositionDao jobPositionDao;

    @Autowired
    public FormCheckManager(CandidateDao candidateDao,FakeMernisService fakeMernisService,EmployerDao employerDao,PersonDao personDao,JobPositionDao jobPositionDao) {
        this.candidateDao = candidateDao;
        this.fakeMernisService = fakeMernisService;
        this.employerDao = employerDao;
        this.personDao = personDao;
        this.jobPositionDao = jobPositionDao;
    }

    @Override
    public boolean isCheckInput(String input) {
        return !input.trim().isEmpty() && input.length() >= 3;
    }

    @Override
    public boolean isCheckPassword(User user) {
        return user.getPassword().equals(user.getPassword_verify());
    }

    @Override
    public boolean isCheckEmail(String email) {
        return candidateDao.findAllByEmail(email).size() == 0;
    }

    @Override
    public boolean isCheckEmployerEmail(String email) {
        return employerDao.findAllByEmail(email).size() == 0;
    }


    @Override
    public boolean isCheckCompanyEmail(Employer employer) {
        String email = employer.getEmail();
        String[] emails = email.split("@");
        return emails[1].equals(employer.getWebSite());
    }

    @Override
    public boolean isCheckPersonEmail(String email) {
            return personDao.findAllByEmail(email).size() == 0;
    }


    @Override
    public boolean isCheckNationalId(String nationalId) {
        return candidateDao.findAllByNationalId(nationalId).size() == 0 || nationalId.length() == 11;
    }

    @Override
    public boolean isCheckMernis(String nationalId, String name, String surname,String year) {
        return fakeMernisService.validateByMernis(nationalId,name,surname,year);
    }

    @Override
    public boolean isCheckTitle(String title) {
        return jobPositionDao.findAllByTitle(title).size() == 0;
    }

}
