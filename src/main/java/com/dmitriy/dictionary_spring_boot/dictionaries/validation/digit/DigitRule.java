package com.dmitriy.dictionary_spring_boot.dictionaries.validation.digit;

import com.dmitriy.dictionary_spring_boot.dictionaries.validation.IRule;

public class DigitRule implements IRule {
    @Override
    public boolean validate(String input) {
        return input.matches("\\d");
    }
}
