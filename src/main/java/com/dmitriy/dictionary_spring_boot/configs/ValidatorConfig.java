package com.dmitriy.dictionary_spring_boot.configs;

import com.dmitriy.dictionary_spring_boot.dictionaries.validation.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ValidatorConfig {

    @Bean
    public IValidator latinValidator(@LatinValidation List<IRule> latinRules) {
        return new LatinValidator(latinRules);
    }

    @Bean
    public IValidator digitValidator(@DigitValidation List<IRule> digitRules) {
        return new DigitValidator(digitRules);
    }

    @Bean
    @LatinValidation
    public IRule latinRule() {
        return new LatinRule();
    }

    @Bean
    @DigitValidation
    public IRule digitRule() {
        return new DigitRule();
    }
}
