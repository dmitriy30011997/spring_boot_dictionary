package com.dmitriy.dictionary_spring_boot.dictionaries.repositories;

import spring.dictionary.entities.IConvertible;

import java.util.List;
import java.util.Optional;

public interface IDictionaryRepository<T> {
    void addEntry(String key, String value);

    void deleteEntry(String key);

    Optional<String> findEntry(String key);

    List<IConvertible> getDictionary();

}

