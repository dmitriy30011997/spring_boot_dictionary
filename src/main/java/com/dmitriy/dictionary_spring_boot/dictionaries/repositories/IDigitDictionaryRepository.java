package com.dmitriy.dictionary_spring_boot.dictionaries.repositories;

import com.dmitriy.dictionary_spring_boot.entities.DigitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IDigitDictionaryRepository extends JpaRepository<DigitEntity, Integer> {

    void deleteByDigitKey(String digitKey);

    Optional<String> findDigitValueByDigitKey(String digitKey);
}
