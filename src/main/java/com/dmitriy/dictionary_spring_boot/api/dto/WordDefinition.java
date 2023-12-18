package com.dmitriy.dictionary_spring_boot.api.dto;

import java.util.List;

public class WordDefinition {
    private String word;
    private List<Phonetic> phonetics;
    private String origin;
    private List<Meaning> meanings;

    public WordDefinition(String word, List<Phonetic> phonetics, String origin, List<Meaning> meanings) {
        this.word = word;
        this.phonetics = phonetics;
        this.origin = origin;
        this.meanings = meanings;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public List<Phonetic> getPhonetics() {
        return phonetics;
    }

    public void setPhonetics(List<Phonetic> phonetics) {
        this.phonetics = phonetics;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public List<Meaning> getMeanings() {
        return meanings;
    }

    public void setMeanings(List<Meaning> meanings) {
        this.meanings = meanings;
    }
}
