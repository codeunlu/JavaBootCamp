package com.codeunlu.HrmsOdev.api.controllers;

import com.codeunlu.HrmsOdev.business.abstracts.VerifactionPersonService;
import com.codeunlu.HrmsOdev.business.abstracts.VerifactionService;
import com.codeunlu.HrmsOdev.core.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/verifactions")
public class VerifactionController {

    private VerifactionService verifactionService;
    private VerifactionPersonService verifactionPersonService;

    @Autowired
    public VerifactionController(VerifactionService verifactionService,VerifactionPersonService verifactionPersonService){
        this.verifactionService = verifactionService;
        this.verifactionPersonService = verifactionPersonService;
    }

    @PostMapping("/codes")
    public Result updateUser(@RequestParam String code){
        return this.verifactionService.findAllByCode(code);
    }

    @PostMapping("/persons")
    public Result updateSystemPerson(@RequestParam int userId,@RequestParam int personId){
        return this.verifactionPersonService.verifyPerson(personId,userId);
    }

}
