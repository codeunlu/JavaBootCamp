package com.codeunlu.HrmsFinal.api.controllers;

import com.codeunlu.HrmsFinal.business.abstracts.CandidateSocialService;
import com.codeunlu.HrmsFinal.entities.concretes.CandidateSocial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/candidateSocials")
public class CandidateSocialController {
    private CandidateSocialService candidateSocialService;
    @Autowired
    public CandidateSocialController(CandidateSocialService candidateSocialService){
        this.candidateSocialService = candidateSocialService;
    }
    @PostMapping(value = "/add")
    public ResponseEntity<?> add(@Valid @RequestBody CandidateSocial candidateSocial){
        return ResponseEntity.ok(this.candidateSocialService.add(candidateSocial));
    }

}
