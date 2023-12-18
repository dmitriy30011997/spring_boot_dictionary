package com.dmitriy.dictionary_spring_boot.api;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictionaryAPIService {

    private final DictionaryAPI dictionaryAPI;

    public DictionaryAPIService(DictionaryAPI dictionaryAPI) {
        this.dictionaryAPI = dictionaryAPI;
    }

    public List<WordDefinition> getWordDefinition(String word) {
        return dictionaryAPI.getWordDefinition(word);
    }
}
