package com.codeunlu.HrmsFinal.api.controllers;

import com.codeunlu.HrmsFinal.business.abstracts.EducationService;
import com.codeunlu.HrmsFinal.entities.concretes.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/educations")
public class EducationController {
    private EducationService educationService;
    @Autowired
    public EducationController(EducationService educationService){
        this.educationService = educationService;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> add(@Valid @RequestBody Education education){
        return ResponseEntity.ok(this.educationService.add(education));
    }
}
