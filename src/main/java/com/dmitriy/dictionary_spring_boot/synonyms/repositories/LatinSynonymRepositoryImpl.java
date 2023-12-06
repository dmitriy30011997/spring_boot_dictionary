package com.dmitriy.dictionary_spring_boot.synonyms.repositories;

import com.dmitriy.dictionary_spring_boot.entities.LatinSynonymEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public class LatinSynonymRepositoryImpl implements ISynonymRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void addSynonym(String word, String synonym) {
        LatinSynonymEntity synonymEntity = new LatinSynonymEntity();
        synonymEntity.setWord(word);
        synonymEntity.setSynonym(synonym);
        entityManager.persist(synonymEntity);
    }

    @Override
    public void deleteSynonym(String synonym) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaDelete<LatinSynonymEntity> query = builder.createCriteriaDelete(LatinSynonymEntity.class);

        Root<LatinSynonymEntity> root = query.from(LatinSynonymEntity.class);
        query.where(builder.equal(root.get("synonym"), synonym));

        entityManager.createQuery(query).executeUpdate();
    }


    @Override
    public List<String> getSynonyms(String word) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<String> query = builder.createQuery(String.class);

        Root<LatinSynonymEntity> root = query.from(LatinSynonymEntity.class);
        query.select(root.get("synonym"));

        Predicate predicate = builder.equal(root.get("word"), word);
        query.where(predicate);

        return entityManager.createQuery(query).getResultList();
    }
}