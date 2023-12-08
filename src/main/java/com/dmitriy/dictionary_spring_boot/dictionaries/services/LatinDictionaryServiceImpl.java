package com.dmitriy.dictionary_spring_boot.dictionaries.services;

import com.dmitriy.dictionary_spring_boot.dictionaries.repositories.ILatinDictionaryRepository;
import com.dmitriy.dictionary_spring_boot.dictionaries.validation.IValidator;
import com.dmitriy.dictionary_spring_boot.dictionaries.validation.latin.LatinValidation;
import com.dmitriy.dictionary_spring_boot.entities.LatinEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class LatinDictionaryServiceImpl implements IDictionaryService {

    private final ILatinDictionaryRepository latinDictionaryRepository;
    private final IValidator latinValidator;

    @Autowired
    public LatinDictionaryServiceImpl(ILatinDictionaryRepository latinDictionaryRepository, IValidator latinValidator) {
        this.latinDictionaryRepository = latinDictionaryRepository;
        this.latinValidator = latinValidator;
    }

    @Override
    @LatinValidation
    public void add(String key, String value) {
        LatinEntity latinEntity = new LatinEntity();
        latinEntity.setLatinKey(key);
        latinEntity.setLatinValue(value);
        latinDictionaryRepository.save(latinEntity);
    }

    @Override
    public void delete(String key) {
        latinDictionaryRepository.deleteByLatinKey(key);
    }

    @Override
    public String viewDictionaryContents() {

        return latinDictionaryRepository.findAll().toString();
    }

    @Override
    public Optional<LatinEntity> findEntry(String key) {
        return latinDictionaryRepository.findLatinValueByLatinKey(key);
    }
}
