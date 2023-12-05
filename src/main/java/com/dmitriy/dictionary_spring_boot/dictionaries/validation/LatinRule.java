package com.dmitriy.dictionary_spring_boot.dictionaries.validation;

public class LatinRule implements IRule {
    @Override
    public boolean validate(String input) {
        return input.matches("[a-zA-Z]+");
    }
}