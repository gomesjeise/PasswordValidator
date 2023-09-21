package com.br.itau.validator.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorServiceTest {

    ValidatorService validatorService = new ValidatorService();

    final String validPassword = "AbTp9!fok";

    @Test
    void passwordHasLessThen9Characters() {
        assertFalse(validatorService.isValid("eh"));
    }

    @Test
    void passwordIsEmpty() {
        assertFalse(validatorService.isValid(""));
    }

    @Test
    void passwordIsNull() {
        assertFalse(validatorService.isValid(null));
    }

    @Test
    void isValidPassword() {
       assertTrue(validatorService.isValid(validPassword));
    }

    @Test
    void isInvalidPasswordUpperCase() {
        assertFalse(validatorService.isValid("abtp9!fok"));
    }
    @Test
    void isInvalidPasswordLowerCase() {
        assertFalse(validatorService.isValid("ABTP9!FOK"));
    }
    @Test
    void isInvalidPasswordDigit() {
        assertFalse(validatorService.isValid("AbTpi!fok"));
    }

    @Test
    void isInvalidPasswordSpecial() {
        assertFalse(validatorService.isValid("AbTpiufok"));
    }

    @Test
    void isInvalidPasswordWhiteSpace() {
        assertFalse(validatorService.isValid("AbTp9! fok"));
    }

    @Test
    void isInvalidPasswordDuplication() {
        assertFalse(validatorService.isValid("AbTp9!foAA"));
    }
}