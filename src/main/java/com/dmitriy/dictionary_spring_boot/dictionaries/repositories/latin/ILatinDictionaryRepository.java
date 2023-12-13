package com.dmitriy.dictionary_spring_boot.dictionaries.repositories.latin;

import com.dmitriy.dictionary_spring_boot.entities.LatinEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ILatinDictionaryRepository extends JpaRepository<LatinEntity, Long> {

    void deleteByLatinKey(String latinKey);
    Optional<LatinValueProjection> findLatinValueByLatinKey(String latinKey);
    Page<LatinEntity> findAll(Pageable pageable);
    }

