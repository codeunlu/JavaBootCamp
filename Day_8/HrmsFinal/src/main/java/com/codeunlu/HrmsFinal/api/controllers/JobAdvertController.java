package com.codeunlu.HrmsFinal.api.controllers;

import com.codeunlu.HrmsFinal.business.abstracts.JobAdvertService;
import com.codeunlu.HrmsFinal.core.utilies.results.DataResult;
import com.codeunlu.HrmsFinal.core.utilies.results.Result;
import com.codeunlu.HrmsFinal.entities.concretes.JobAdvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobadverts")
public class JobAdvertController {

    private JobAdvertService jobAdvertService;
    @Autowired
    public JobAdvertController(
            JobAdvertService jobAdvertService
    ){
        this.jobAdvertService = jobAdvertService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobAdvert jobAdvert){
        return this.jobAdvertService.add(jobAdvert);
    }

    @GetMapping("/active")
    public DataResult<List<JobAdvert>> getByActiveTrue(){
        return this.jobAdvertService.getByActiveTrue();
    }

    @GetMapping("/desc")
    public DataResult<List<JobAdvert>> getByReleaseDateDesc(){
        return this.jobAdvertService.getByReleaseDateDesc();
    }

    @GetMapping("/asc")
    public DataResult<List<JobAdvert>> getByReleaseDateAsc(){
        return this.jobAdvertService.getByReleaseDateAsc();
    }

    @GetMapping("/employers/{id}")
    public DataResult<List<JobAdvert>> getByEmployersId(@PathVariable int id){
        return this.jobAdvertService.getByEmployersId(id);
    }
}
