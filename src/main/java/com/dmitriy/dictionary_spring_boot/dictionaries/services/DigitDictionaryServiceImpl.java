package com.dmitriy.dictionary_spring_boot.dictionaries.services;

import com.dmitriy.dictionary_spring_boot.dictionaries.repositories.IDigitDictionaryRepository;
import com.dmitriy.dictionary_spring_boot.dictionaries.validation.IValidator;
import com.dmitriy.dictionary_spring_boot.entities.DigitEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
public class DigitDictionaryServiceImpl implements IDictionaryService {

    private final IDigitDictionaryRepository digitDictionaryRepository;
    private final IValidator digitValidator;


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
            System.out.println("Введено некорректное значение");
        }
    }

    @Override
    @Transactional
    public void delete(String key) {
        digitDictionaryRepository.deleteByDigitKey(key);
    }

    public String viewDictionaryContents() {
        System.out.println("Содержимое цифрового словаря: ");

        return digitDictionaryRepository.findAll().toString();
    }

    @Override
    public Optional<String> findEntry(String key) {
        return digitDictionaryRepository.findDigitValueByDigitKey(key);
    }
}
