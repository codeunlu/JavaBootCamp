package com.codeunlu.HrmsOdev.api.controllers;

import com.codeunlu.HrmsOdev.business.abstracts.PersonService;
import com.codeunlu.HrmsOdev.core.utilities.results.DataResult;
import com.codeunlu.HrmsOdev.core.utilities.results.Result;
import com.codeunlu.HrmsOdev.entities.concretes.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService){
        this.personService = personService;
    }

    @GetMapping("/get")
    public DataResult<List<Person>> get(){
        return this.personService.get();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Person person){
        return this.personService.add(person);
    }


}
