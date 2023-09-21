package com.br.itau.validator.service;

import org.springframework.stereotype.Service;

@Service
public class ValidatorService {

    private final String specialCharacter = "!@#$%^&*()-+";

    public boolean isValid(String password) {

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        if(password == null) return false;
        if(password.length() < 9) {
            System.out.println("less then 9 characters");
            return false;
        }
        String characters = "";

        for(int i = 0; i < password.length(); i++) {
            char pass = password.charAt(i);

            if(Character.isWhitespace(pass)) {
                System.out.println("Whitespace");
                return false;
            }

            if(Character.isUpperCase(pass)) {
                System.out.println("upperCase");
                hasUpper = true;
            }

            if(Character.isLowerCase(pass)) {
                System.out.println("lowerCase");
                hasLower = true;
            }

            if(Character.isDigit(pass)) {
                System.out.println("digit");
                hasDigit = true;
            }

            if(specialCharacter.contains(String.valueOf(pass))){
                System.out.println("special: " + pass);
                hasSpecial = true;
            }

            if(characters.contains(String.valueOf(pass))) { //Testar com o Map
                System.out.println("duplication: " + pass);
                return false;
            }
            characters += pass;
            System.out.println(characters);

        }

        return hasDigit && hasLower && hasUpper && hasSpecial;
    }
}
