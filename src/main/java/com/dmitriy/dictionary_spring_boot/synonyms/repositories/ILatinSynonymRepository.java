package com.dmitriy.dictionary_spring_boot.synonyms.repositories;

import com.dmitriy.dictionary_spring_boot.entities.LatinSynonymEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ILatinSynonymRepository extends JpaRepository<LatinSynonymEntity, Long> {
    List<LatinSynonymEntity> findByWord(String word);
    @Transactional
    void deleteBySynonym(String synonym);
}
