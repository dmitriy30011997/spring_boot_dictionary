package com.dmitriy.dictionary_spring_boot.dictionaries.validation;

public interface IRule {
    boolean validate(String input);
}