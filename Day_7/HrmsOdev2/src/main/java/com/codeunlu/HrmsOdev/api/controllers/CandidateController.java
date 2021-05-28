package com.codeunlu.HrmsOdev.api.controllers;

import com.codeunlu.HrmsOdev.business.abstracts.CandidateService;
import com.codeunlu.HrmsOdev.core.utilities.results.DataResult;
import com.codeunlu.HrmsOdev.core.utilities.results.Result;
import com.codeunlu.HrmsOdev.entities.concretes.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {

    private CandidateService candidateService;

    @Autowired
    public CandidateController(CandidateService candidateService){
        this.candidateService = candidateService;
    }

    @GetMapping("/get")
    public DataResult<List<Candidate>> get(){
        return this.candidateService.get();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Candidate candidate){
        return this.candidateService.add(candidate);
    }
}
