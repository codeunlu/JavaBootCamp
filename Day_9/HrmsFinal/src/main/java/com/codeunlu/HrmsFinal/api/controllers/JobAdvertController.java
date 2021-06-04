package com.codeunlu.HrmsFinal.api.controllers;

import com.codeunlu.HrmsFinal.business.abstracts.JobAdvertService;
import com.codeunlu.HrmsFinal.core.utilies.results.DataResult;
import com.codeunlu.HrmsFinal.core.utilies.results.Result;
import com.codeunlu.HrmsFinal.entities.concretes.JobAdvert;
import com.codeunlu.HrmsFinal.entities.dto.JobAdvertDto;
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

    @GetMapping("/getByActiveAdverts")
    public DataResult<List<JobAdvertDto>> getActiveAdverts(){
        return this.jobAdvertService.getActiveAdverts();
    }

    @GetMapping("/getActiveAdvertsDesc")
    public DataResult<List<JobAdvertDto>> getActiveAdvertsDesc(){
        return this.jobAdvertService.getActiveAdvertsDesc();
    }

    @GetMapping("/getActiveAdvertsAsc")
    public DataResult<List<JobAdvertDto>> getActiveAdvertsAsc(){
        return this.jobAdvertService.getActiveAdvertsAsc();
    }

    @GetMapping("/getActiveAdvertsEmployer/{id}")
    public DataResult<List<JobAdvertDto>> getActiveAdvertsEmployer(@PathVariable int id){
        return this.jobAdvertService.getActiveAdvertsEmployer(id);
    }
}
