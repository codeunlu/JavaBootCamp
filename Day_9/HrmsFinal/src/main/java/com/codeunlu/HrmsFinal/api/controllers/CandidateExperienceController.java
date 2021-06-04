package com.codeunlu.HrmsFinal.api.controllers;

import com.codeunlu.HrmsFinal.business.abstracts.CandidateExperienceService;
import com.codeunlu.HrmsFinal.entities.concretes.CandidateExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/candidateExperiences")
public class CandidateExperienceController {
    private CandidateExperienceService candidateExperienceService;
    @Autowired
    public CandidateExperienceController(CandidateExperienceService candidateExperienceService){
        this.candidateExperienceService = candidateExperienceService;
    }
    @PostMapping(value = "/add")
    public ResponseEntity<?> add(@Valid @RequestBody CandidateExperience candidateExperience){
        return ResponseEntity.ok(this.candidateExperienceService.add(candidateExperience));
    }

    @PostMapping(value = "/getDesc/{id}")
    public ResponseEntity<?> getDesc(@Valid @PathVariable int id){
        return ResponseEntity.ok(
                this.candidateExperienceService.getCandidateExperienceByCandidate_IdOrderByEndYearDesc(id));
    }
}
