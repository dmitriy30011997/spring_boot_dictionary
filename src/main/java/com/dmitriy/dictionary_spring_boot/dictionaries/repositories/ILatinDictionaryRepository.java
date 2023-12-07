package com.dmitriy.dictionary_spring_boot.dictionaries.repositories;

import com.dmitriy.dictionary_spring_boot.entities.LatinEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ILatinDictionaryRepository extends JpaRepository<LatinEntity, Long> {

    void deleteByLatinKey(String latinKey);
        Optional<LatinEntity> findLatinValueByLatinKey(@Param("key") String latinKey);
    }

