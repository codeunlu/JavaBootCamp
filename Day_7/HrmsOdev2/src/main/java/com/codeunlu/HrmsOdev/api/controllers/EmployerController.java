package com.codeunlu.HrmsOdev.api.controllers;

import com.codeunlu.HrmsOdev.business.abstracts.EmployerService;
import com.codeunlu.HrmsOdev.core.utilities.results.DataResult;
import com.codeunlu.HrmsOdev.core.utilities.results.Result;
import com.codeunlu.HrmsOdev.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employers")
public class EmployerController {

    private EmployerService employerService;

    @Autowired
    public EmployerController(EmployerService employerService){
        this.employerService = employerService;
    }

    @GetMapping("/get")
    public DataResult<List<Employer>> get(){
        return this.employerService.get();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Employer employer){
        return this.employerService.add(employer);
    }
}
