package com.dmitriy.dictionary_spring_boot.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "digit_synonym")
public class DigitSynonymEntity implements Serializable, IConvertible {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "word")
    private String word;

    @Column(name = "synonym")
    private String synonym;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "digit_entity_id")
    private DigitEntity digitEntity;


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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DigitEntity getDigitEntity() {
        return digitEntity;
    }

    public void setDigitEntity(DigitEntity digitEntity) {
        this.digitEntity = digitEntity;
    }
}

