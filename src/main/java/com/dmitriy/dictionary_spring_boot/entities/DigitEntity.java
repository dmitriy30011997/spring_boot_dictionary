package com.dmitriy.dictionary_spring_boot.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "digit_dictionary")
public class DigitEntity implements Serializable, IConvertible {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "digit_entity_id")
    private Long id;

    @Column(name = "digit_key")
    private String digitKey;

    @Column(name = "digit_value")
    private String digitValue;

    @OneToMany(mappedBy = "digitEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DigitSynonymEntity> synonyms = new ArrayList<>();

    public DigitEntity(String digitKey, String digitValue) {
        this.digitKey = digitKey;
        this.digitValue = digitValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKey() {
        return digitKey;
    }

    public void setDigitKey(String digitKey) {
        this.digitKey = digitKey;
    }

    public String getValue() {
        return digitValue;
    }

    public void setDigitValue(String digitValue) {
        this.digitValue = digitValue;
    }

    public List<DigitSynonymEntity> getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(List<DigitSynonymEntity> synonyms) {
        this.synonyms = synonyms;
    }

    public DigitEntity() {
    }
}
