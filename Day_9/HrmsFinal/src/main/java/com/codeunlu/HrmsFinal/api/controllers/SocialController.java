package com.codeunlu.HrmsFinal.api.controllers;

import com.codeunlu.HrmsFinal.business.abstracts.SocialService;
import com.codeunlu.HrmsFinal.entities.concretes.Social;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/socials")
public class SocialController {
    private SocialService socialService;

    @Autowired
    public SocialController(SocialService socialService){
        this.socialService = socialService;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> add(@Valid @RequestBody Social social){
        return ResponseEntity.ok(this.socialService.add(social));
    }
}
