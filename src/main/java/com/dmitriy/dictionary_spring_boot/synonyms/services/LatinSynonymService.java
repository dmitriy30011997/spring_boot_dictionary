package com.dmitriy.dictionary_spring_boot.synonyms.services;

import com.dmitriy.dictionary_spring_boot.entities.LatinSynonymEntity;
import com.dmitriy.dictionary_spring_boot.synonyms.repositories.latin.ILatinSynonymRepository;
import com.dmitriy.dictionary_spring_boot.synonyms.repositories.latin.LatinSynonymProjection;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LatinSynonymService implements ISynonymService {

    private final ILatinSynonymRepository latinSynonymRepository;

    public LatinSynonymService(ILatinSynonymRepository latinSynonymRepository) {
        this.latinSynonymRepository = latinSynonymRepository;
    }

    @Transactional
    public void addSynonym(String word, String synonym) {
        LatinSynonymEntity synonymEntity = new LatinSynonymEntity();
        synonymEntity.setWord(word);
        synonymEntity.setSynonym(synonym);
        latinSynonymRepository.save(synonymEntity);
    }

    @Transactional
    public void deleteSynonym(String synonym) {
        latinSynonymRepository.deleteBySynonym(synonym);
    }

    @Transactional(readOnly = true)
    public List<String> getSynonyms(String word) {
        List<LatinSynonymProjection> synonymEntities = latinSynonymRepository.findByWord(word);
        return synonymEntities.stream()
                .map(LatinSynonymProjection::getSynonym)
                .collect(Collectors.toList());
    }
}
