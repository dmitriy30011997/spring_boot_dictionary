package com.dmitriy.dictionary_spring_boot.dictionaries.repositories;

import com.dmitriy.dictionary_spring_boot.entities.DigitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IDigitDictionaryRepository extends JpaRepository<DigitEntity, Long> {

    void deleteByDigitKey(String digitKey);

    @Query("SELECT d.digitValue FROM DigitEntity d WHERE d.digitKey = :key")
    Optional<String> findDigitValueByDigitKey(String key);
}

