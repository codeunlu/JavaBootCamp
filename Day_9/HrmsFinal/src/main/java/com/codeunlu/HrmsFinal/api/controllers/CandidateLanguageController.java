package com.codeunlu.HrmsFinal.api.controllers;

import com.codeunlu.HrmsFinal.business.abstracts.CandidateLanguageService;
import com.codeunlu.HrmsFinal.entities.concretes.CandidateLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/candidateLanguages")
public class CandidateLanguageController {
    private CandidateLanguageService candidateLanguageService;
    @Autowired
    public CandidateLanguageController(CandidateLanguageService candidateLanguageService){
        this.candidateLanguageService = candidateLanguageService;
    }
    @PostMapping(value = "/add")
    public ResponseEntity<?> add(@Valid @RequestBody CandidateLanguage candidateLanguage){
        return ResponseEntity.ok(this.candidateLanguageService.add(candidateLanguage));
    }
}
