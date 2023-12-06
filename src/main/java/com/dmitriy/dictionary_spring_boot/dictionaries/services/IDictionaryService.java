package com.dmitriy.dictionary_spring_boot.dictionaries.services;

import java.util.Optional;

public interface IDictionaryService {
    void add(String key, String value);
    void delete(String key);
    String viewDictionaryContents();
    Optional findEntry(String key);
}
