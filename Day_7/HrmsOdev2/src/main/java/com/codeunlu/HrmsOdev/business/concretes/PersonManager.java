package com.codeunlu.HrmsOdev.business.concretes;

import com.codeunlu.HrmsOdev.business.abstracts.FormCheckService;
import com.codeunlu.HrmsOdev.business.abstracts.PersonService;
import com.codeunlu.HrmsOdev.core.utilities.results.*;
import com.codeunlu.HrmsOdev.dataAccess.abstracts.PersonDao;
import com.codeunlu.HrmsOdev.entities.concretes.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonManager implements PersonService {

    private PersonDao personDao;
    private FormCheckService form;

    @Autowired
    public PersonManager(PersonDao personDao,FormCheckService form){

        this.personDao = personDao;
        this.form = form;
    }
    @Override
    public DataResult<List<Person>> get() {
        return new SuccessDataResult<List<Person>>(this.personDao.findAll(),"All Person Listed!");
    }

    @Override
    public Result add(Person person) {
        if(!form.isCheckPersonEmail(person.getEmail())){
            return new ErrorResult("Email dont use!");
        }else if(!form.isCheckPassword(person)){
            return new ErrorResult("Passwords do not match.");
        }else if(!form.isCheckInput(person.getName())){
            return new ErrorResult("Name is wrong.");
        }else if(!form.isCheckInput(person.getSurname())){
            return new ErrorResult("Surname is wrong.");
        }
        this.personDao.save(person);
        return new SuccessResult("Register is completed.");
    }
}
