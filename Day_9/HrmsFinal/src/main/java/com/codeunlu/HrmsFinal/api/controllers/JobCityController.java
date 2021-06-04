package com.codeunlu.HrmsFinal.api.controllers;

import com.codeunlu.HrmsFinal.business.abstracts.JobCityService;
import com.codeunlu.HrmsFinal.core.utilies.results.Result;
import com.codeunlu.HrmsFinal.entities.concretes.JobCity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cities")
public class JobCityController {
    private JobCityService jobCityService;
    @Autowired
    public JobCityController(
            JobCityService jobCityService
    ){
        this.jobCityService = jobCityService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobCity jobCity){
        return this.jobCityService.add(jobCity);
    }
}
