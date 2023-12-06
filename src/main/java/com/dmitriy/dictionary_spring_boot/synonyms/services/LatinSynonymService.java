package com.dmitriy.dictionary_spring_boot.synonyms.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dmitriy.dictionary_spring_boot.synonyms.repositories.ISynonymRepository;

import java.util.List;


public class LatinSynonymService implements ISynonymService {

    private final ISynonymRepository latinSynonymRepository;

    public LatinSynonymService(ISynonymRepository latinSynonymRepository) {
        this.latinSynonymRepository = latinSynonymRepository;
    }

    @Transactional
    public void addSynonym(String word, String synonym) {
        latinSynonymRepository.addSynonym(word, synonym);
    }

    @Transactional
    public void deleteSynonym(String synonym) {
        latinSynonymRepository.deleteSynonym(synonym);
    }

    @Transactional
    public List<String> getSynonyms(String word) {
        return latinSynonymRepository.getSynonyms(word);
    }

    @Override
    public int getType() {
        return 1;
    }
}

