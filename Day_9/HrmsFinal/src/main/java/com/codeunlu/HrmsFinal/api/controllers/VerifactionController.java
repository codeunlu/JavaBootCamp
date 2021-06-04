package com.codeunlu.HrmsFinal.api.controllers;

import com.codeunlu.HrmsFinal.business.abstracts.VerifactionService;
import com.codeunlu.HrmsFinal.core.utilies.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/verifactions")
public class VerifactionController {
    private VerifactionService verifactionService;

    @Autowired
    public VerifactionController(VerifactionService verifactionService){
        this.verifactionService = verifactionService;
    }

    @PostMapping("/codes")
    public Result active(@RequestParam String code){
        return this.verifactionService.active(code);
    }
    @PostMapping("/employees")
    public Result activeEmployee(@RequestParam int userId,@RequestParam int employeeId){
        return this.verifactionService.activeEmployee(userId,employeeId);
    }

}
