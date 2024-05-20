package com.example.cross_prog_2.task;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;

public class NoProfanityValidator implements ConstraintValidator<NoProfanity, String> {
    private final List<String> forbiddenWords = Arrays.asList("bitch", "fuck");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        String lowerCaseValue = value.toLowerCase();
        return forbiddenWords.stream().noneMatch(lowerCaseValue::contains);
    }
}
