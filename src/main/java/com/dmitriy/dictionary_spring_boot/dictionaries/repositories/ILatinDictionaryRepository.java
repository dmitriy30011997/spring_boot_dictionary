package com.dmitriy.dictionary_spring_boot.dictionaries.repositories;

import com.dmitriy.dictionary_spring_boot.entities.LatinEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ILatinDictionaryRepository extends JpaRepository<LatinEntity, Integer> {

    void deleteByLatinKey(String latinKey);

    Optional<String> findLatinValueByLatinKey(String latinKey);
}
