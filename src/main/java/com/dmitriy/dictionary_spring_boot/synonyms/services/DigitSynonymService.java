package com.dmitriy.dictionary_spring_boot.synonyms.services;

import com.dmitriy.dictionary_spring_boot.entities.DigitSynonymEntity;
import com.dmitriy.dictionary_spring_boot.synonyms.repositories.IDigitSynonymRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DigitSynonymService implements ISynonymService {

    private final IDigitSynonymRepository digitSynonymRepository;

    public DigitSynonymService(IDigitSynonymRepository digitSynonymRepository) {
        this.digitSynonymRepository = digitSynonymRepository;
    }

    @Transactional
    public void addSynonym(String word, String synonym) {
        DigitSynonymEntity synonymEntity = new DigitSynonymEntity();
        synonymEntity.setWord(word);
        synonymEntity.setSynonym(synonym);
        digitSynonymRepository.save(synonymEntity);
    }

    @Transactional
    public void deleteSynonym(String synonym) {
        digitSynonymRepository.deleteBySynonym(synonym);
    }

    @Transactional(readOnly = true)
    public List<String> getSynonyms(String word) {
        List<DigitSynonymEntity> synonymEntities = digitSynonymRepository.findByWord(word);
        return synonymEntities.stream()
                .map(DigitSynonymEntity::getSynonym)
                .collect(Collectors.toList());
    }
}
