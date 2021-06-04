package com.codeunlu.HrmsFinal.api.controllers;

import com.codeunlu.HrmsFinal.business.abstracts.CandidateEducationService;
import com.codeunlu.HrmsFinal.entities.concretes.CandidateEducation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/candidateEducations")
public class CandidateEducationController {
    private CandidateEducationService candidateEducationService;
    @Autowired
    public CandidateEducationController(CandidateEducationService candidateEducationService){
        this.candidateEducationService = candidateEducationService;
    }
    @PostMapping(value = "/add")
    public ResponseEntity<?> add(@Valid @RequestBody CandidateEducation candidateEducation){
        return ResponseEntity.ok(this.candidateEducationService.add(candidateEducation));
    }

    @PostMapping(value = "/getDesc/{id}")
    public ResponseEntity<?> getDesc(@Valid @PathVariable int id){
        return ResponseEntity.ok(
                this.candidateEducationService.getCandidateEducationByCandidate_IdOrderByEndYearDesc(id));
    }
}
