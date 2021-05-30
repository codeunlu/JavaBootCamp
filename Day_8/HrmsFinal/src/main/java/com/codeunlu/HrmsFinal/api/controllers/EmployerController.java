package com.codeunlu.HrmsFinal.api.controllers;

import com.codeunlu.HrmsFinal.business.abstracts.EmployerService;
import com.codeunlu.HrmsFinal.core.utilies.results.DataResult;
import com.codeunlu.HrmsFinal.core.utilies.results.Result;
import com.codeunlu.HrmsFinal.entities.concretes.Employer;
import com.codeunlu.HrmsFinal.entities.concretes.JobAdvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employers")
public class EmployerController {

    private EmployerService employerService;
    @Autowired
    public EmployerController(
            EmployerService employerService
    ){
        this.employerService = employerService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody Employer employer){
        return this.employerService.add(employer);
    }

    @GetMapping("/getall")
    public DataResult<List<Employer>> getAll(){
        return this.employerService.getAll();
    }

    @PostMapping("/passive/{employerId}/{id}")
    public Result passive(@PathVariable int employerId,@PathVariable int id){
        return this.employerService.passive(employerId,id);
    }
}
