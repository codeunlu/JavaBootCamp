package com.codeunlu.HrmsOdev.api.controllers;

import com.codeunlu.HrmsOdev.business.abstracts.JobPositionService;
import com.codeunlu.HrmsOdev.core.utilities.results.DataResult;
import com.codeunlu.HrmsOdev.core.utilities.results.Result;
import com.codeunlu.HrmsOdev.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobpositions")
public class JobPositionController {

    private JobPositionService jobPositionService;

    @Autowired
    public JobPositionController(JobPositionService jobPositionService){
        this.jobPositionService = jobPositionService;
    }

    @GetMapping("/get")
    public DataResult<List<JobPosition>> get(){
        return this.jobPositionService.get();
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobPosition jobPosition){
        return this.jobPositionService.add(jobPosition);
    }

}
