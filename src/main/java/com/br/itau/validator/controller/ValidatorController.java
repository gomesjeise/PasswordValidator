package com.br.itau.validator.controller;

import com.br.itau.validator.service.ValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("isValid")
public class ValidatorController {

    @Autowired
    private ValidatorService validatorService;

    @GetMapping("/{password}")
    public boolean isValidPassword(@PathVariable() String password) {
        return validatorService.isValid(password);
    }
}
