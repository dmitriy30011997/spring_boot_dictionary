package com.dmitriy.dictionary_spring_boot.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "latin_synonym")
public class LatinSynonymEntity implements Serializable, IConvertible {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "word")
    private String word;

    @Column(name = "synonym")
    private String synonym;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "latin_entity_id")
    private LatinEntity latinEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKey() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getValue() {
        return synonym;
    }

    public void setSynonym(String synonym) {
        this.synonym = synonym;
    }

    public LatinEntity getLatinEntity() {
        return latinEntity;
    }

    public String getWord() {
        return word;
    }

    public String getSynonym() {
        return synonym;
    }

    public void setLatinEntity(LatinEntity latinEntity) {
        this.latinEntity = latinEntity;
    }

    @Override
    public String toString() {
        return word + " : " + synonym + "\n";
    }
}
