package com.dmitriy.dictionary_spring_boot.dictionaries.repositories.digit;

import com.dmitriy.dictionary_spring_boot.entities.DigitEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IDigitDictionaryRepository extends JpaRepository<DigitEntity, Long> {

    void deleteByDigitKey(String digitKey);
    Optional<DigitValueProjection> findDigitValueByDigitKey(String key);
    Page<DigitEntity> findAll(Pageable pageable);
}

