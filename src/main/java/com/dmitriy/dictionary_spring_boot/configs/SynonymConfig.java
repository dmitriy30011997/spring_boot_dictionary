package com.dmitriy.dictionary_spring_boot.configs;

import com.dmitriy.dictionary_spring_boot.synonyms.repositories.DigitSynonymRepositoryImpl;
import com.dmitriy.dictionary_spring_boot.synonyms.repositories.ISynonymRepository;
import com.dmitriy.dictionary_spring_boot.synonyms.repositories.LatinSynonymRepositoryImpl;
import com.dmitriy.dictionary_spring_boot.synonyms.services.DigitSynonymService;
import com.dmitriy.dictionary_spring_boot.synonyms.services.ISynonymService;
import com.dmitriy.dictionary_spring_boot.synonyms.services.LatinSynonymService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class SynonymConfig {
    @Bean
    @Primary
    public ISynonymRepository latinSynonymRepository(){
        return new LatinSynonymRepositoryImpl();
    }
    @Bean
    public ISynonymRepository digitSynonymRepository(){
        return new DigitSynonymRepositoryImpl();
    }
    @Bean
    public ISynonymService latinSynonymService() {
        return new LatinSynonymService(latinSynonymRepository());
    }

    @Bean
    public ISynonymService digitSynonymService() {
        return new DigitSynonymService(digitSynonymRepository());
    }
}
