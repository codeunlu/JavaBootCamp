package com.codeunlu.HrmsFinal.api.controllers;

import com.codeunlu.HrmsFinal.business.abstracts.CandidateResumeService;
import com.codeunlu.HrmsFinal.entities.concretes.CandidateResume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/candidateResumes")
public class CandidateResumeController {
    private CandidateResumeService candidateResumeService;

    @Autowired
    public CandidateResumeController(CandidateResumeService candidateResumeService){
        this.candidateResumeService = candidateResumeService;
    }
    @PostMapping(value = "/add")
    public ResponseEntity<?> add(@Valid @RequestBody CandidateResume candidateResume){
        return ResponseEntity.ok(this.candidateResumeService.add(candidateResume));
    }
}
