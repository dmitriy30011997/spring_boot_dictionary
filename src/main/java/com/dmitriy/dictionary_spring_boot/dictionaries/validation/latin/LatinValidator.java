package com.dmitriy.dictionary_spring_boot.dictionaries.validation.latin;

import com.dmitriy.dictionary_spring_boot.dictionaries.validation.IRule;
import com.dmitriy.dictionary_spring_boot.dictionaries.validation.IValidator;

import java.util.List;

public class LatinValidator implements IValidator {
    private final List<IRule> rules;

    public LatinValidator(List<IRule> rules) {
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