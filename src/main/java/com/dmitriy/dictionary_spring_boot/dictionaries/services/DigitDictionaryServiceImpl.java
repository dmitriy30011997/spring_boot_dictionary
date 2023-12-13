package com.dmitriy.dictionary_spring_boot.dictionaries.services;

import com.dmitriy.dictionary_spring_boot.dictionaries.repositories.digit.DigitValueProjection;
import com.dmitriy.dictionary_spring_boot.dictionaries.repositories.digit.IDigitDictionaryRepository;
import com.dmitriy.dictionary_spring_boot.dictionaries.validation.IValidator;
import com.dmitriy.dictionary_spring_boot.entities.DigitEntity;
import com.dmitriy.dictionary_spring_boot.entities.LatinEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
public class DigitDictionaryServiceImpl implements IDictionaryService {

    private final IDigitDictionaryRepository digitDictionaryRepository;
    private final IValidator digitValidator;
    private static final Logger logger = LoggerFactory.getLogger(DigitDictionaryServiceImpl.class);



    @Autowired
    public DigitDictionaryServiceImpl(IDigitDictionaryRepository digitDictionaryRepository, IValidator digitValidator) {
        this.digitDictionaryRepository = digitDictionaryRepository;
        this.digitValidator = digitValidator;
    }

    @Override
    public void add(String key, String value) {
        if (digitValidator.validate(key) && digitValidator.validate(value)) {
            DigitEntity digitEntity = new DigitEntity();
            digitEntity.setDigitKey(key);
            digitEntity.setDigitValue(value);
            digitDictionaryRepository.save(digitEntity);
        } else {
            logger.error("Wrong key or value");
        }
    }

    @Override
    @Transactional
    public void delete(String key) {
        digitDictionaryRepository.deleteByDigitKey(key);
    }
    @Override
    public Page<DigitEntity> viewDictionaryContents(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return digitDictionaryRepository.findAll(pageable);
    }

    @Override
    public Optional<DigitValueProjection> findEntry(String key) {
        return digitDictionaryRepository.findDigitValueByDigitKey(key);
    }
}
