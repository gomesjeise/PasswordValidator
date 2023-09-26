package com.br.itau.validator.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorServiceTest {

    PasswordValidatorService passwordValidatorService = new PasswordValidatorService();

    final String validPassword = "AbTp9!fok";

    @Test
    void passwordHasLessThen9Characters() {
        assertFalse(passwordValidatorService.isValid("eh"));
    }

    @Test
    void passwordIsEmpty() {
        assertFalse(passwordValidatorService.isValid(""));
    }

    @Test
    void passwordIsNull() {
        assertFalse(passwordValidatorService.isValid(null));
    }

    @Test
    void isValidPassword() {
       assertTrue(passwordValidatorService.isValid(validPassword));
    }

    @Test
    void isInvalidPasswordUpperCase() {
        assertFalse(passwordValidatorService.isValid("abtp9!fok"));
    }
    @Test
    void isInvalidPasswordLowerCase() {
        assertFalse(passwordValidatorService.isValid("ABTP9!FOK"));
    }
    @Test
    void isInvalidPasswordDigit() {
        assertFalse(passwordValidatorService.isValid("AbTpi!fok"));
    }

    @Test
    void isInvalidPasswordSpecial() {
        assertFalse(passwordValidatorService.isValid("AbTpiufok"));
    }

    @Test
    void isInvalidPasswordWhiteSpace() {
        assertFalse(passwordValidatorService.isValid("AbTp9! fok"));
    }

    @Test
    void isInvalidPasswordDuplication() {
        assertFalse(passwordValidatorService.isValid("AbTp9!foAA"));
    }
}