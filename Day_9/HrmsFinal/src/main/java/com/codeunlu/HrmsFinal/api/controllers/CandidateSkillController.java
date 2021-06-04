package com.codeunlu.HrmsFinal.api.controllers;

import com.codeunlu.HrmsFinal.business.abstracts.CandidateSkillService;
import com.codeunlu.HrmsFinal.entities.concretes.CandidateSkill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/candidateSkills")
public class CandidateSkillController {
    private CandidateSkillService candidateSkillService;

    @Autowired
    public CandidateSkillController(CandidateSkillService candidateSkillService){
        this.candidateSkillService = candidateSkillService;
    }
    @PostMapping(value = "/add")
    public ResponseEntity<?> add(@Valid @RequestBody CandidateSkill candidateSkill){
        return ResponseEntity.ok(this.candidateSkillService.add(candidateSkill));
    }
}
