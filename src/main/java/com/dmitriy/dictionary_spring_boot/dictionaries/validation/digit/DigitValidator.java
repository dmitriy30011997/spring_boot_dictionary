package com.dmitriy.dictionary_spring_boot.dictionaries.validation.digit;

import com.dmitriy.dictionary_spring_boot.dictionaries.validation.IRule;
import com.dmitriy.dictionary_spring_boot.dictionaries.validation.IValidator;

import java.util.List;

public class DigitValidator implements IValidator {
    private final List<IRule> rules;

    public DigitValidator(List<IRule> rules) {
        this.rules = rules;
    }

    @Override
    public boolean validate(String input) {
        for (IRule rule : rules) {
            if (!rule.validate(input)) {
                return false;
            }
        }
        return true;
    }
}