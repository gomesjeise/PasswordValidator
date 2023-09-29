package com.br.itau.validator.controller;

import com.br.itau.validator.service.PasswordValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValidatorController {

    @Autowired
    private PasswordValidatorService passwordValidatorService;

    @PostMapping(value = "/password", consumes = MediaType.TEXT_PLAIN_VALUE)
    public boolean validatePassword(@RequestBody String password) {
        return passwordValidatorService.isValid(password);
    }
}
