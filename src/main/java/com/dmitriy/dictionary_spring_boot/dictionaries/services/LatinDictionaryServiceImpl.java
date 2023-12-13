package com.dmitriy.dictionary_spring_boot.dictionaries.services;

import com.dmitriy.dictionary_spring_boot.dictionaries.repositories.latin.ILatinDictionaryRepository;
import com.dmitriy.dictionary_spring_boot.dictionaries.repositories.latin.LatinValueProjection;
import com.dmitriy.dictionary_spring_boot.dictionaries.validation.IValidator;
import com.dmitriy.dictionary_spring_boot.entities.LatinEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class LatinDictionaryServiceImpl implements IDictionaryService {

    private final ILatinDictionaryRepository latinDictionaryRepository;
    private final IValidator latinValidator;
    private static final Logger logger = LoggerFactory.getLogger(LatinDictionaryServiceImpl.class);

    @Autowired
    public LatinDictionaryServiceImpl(ILatinDictionaryRepository latinDictionaryRepository, IValidator latinValidator) {
        this.latinDictionaryRepository = latinDictionaryRepository;
        this.latinValidator = latinValidator;
    }

    @Override
    public void add(String key, String value) {
        if(latinValidator.validate(key) && latinValidator.validate(value)) {
            LatinEntity latinEntity = new LatinEntity();
            latinEntity.setLatinKey(key);
            latinEntity.setLatinValue(value);
            latinDictionaryRepository.save(latinEntity);
        }
        else {
            logger.error("Wrong key or value");
        }
    }

    @Override
    public void delete(String key) {
        latinDictionaryRepository.deleteByLatinKey(key);
    }

    @Override
    public Page<LatinEntity> viewDictionaryContents(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return latinDictionaryRepository.findAll(pageable);
    }

    @Override
    public Optional<LatinValueProjection> findEntry(String key) {
        return latinDictionaryRepository.findLatinValueByLatinKey(key);
    }
}
