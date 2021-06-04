package com.codeunlu.HrmsFinal.api.controllers;

import com.codeunlu.HrmsFinal.business.abstracts.SchoolDepartmentService;
import com.codeunlu.HrmsFinal.entities.concretes.SchoolDepartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/schooldepartments")
public class SchoolDepartmentController {
    private SchoolDepartmentService schoolDepartmentService;
    @Autowired
    public SchoolDepartmentController(SchoolDepartmentService schoolDepartmentService){
        this.schoolDepartmentService = schoolDepartmentService;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> add(@Valid @RequestBody SchoolDepartment schoolDepartment){
        return ResponseEntity.ok(this.schoolDepartmentService.add(schoolDepartment));
    }
}
