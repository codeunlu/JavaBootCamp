package com.codeunlu.HrmsFinal.api.controllers;


import com.codeunlu.HrmsFinal.business.abstracts.WorkplaceService;
import com.codeunlu.HrmsFinal.entities.concretes.Workplace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/workplaces")
public class WorkplaceController {
    private WorkplaceService workplaceService;

    @Autowired
    public WorkplaceController(WorkplaceService workplaceService){
        this.workplaceService = workplaceService;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> add(@Valid @RequestBody Workplace workplace){
        return ResponseEntity.ok(this.workplaceService.add(workplace));
    }
}
