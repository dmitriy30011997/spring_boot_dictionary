package com.dmitriy.dictionary_spring_boot.dictionaries.services;

import org.springframework.data.domain.Page;

import java.util.Optional;

public interface IDictionaryService {
    void add(String key, String value);
    void delete(String key);
    Page viewDictionaryContents(int page, int size);
    Optional findEntry(String key);
}
