package com.dmitriy.dictionary_spring_boot.controllers;

import com.dmitriy.dictionary_spring_boot.dictionaries.services.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/")
public class DictionaryController {

    private final IDictionaryService digitDictionaryService;
    private final IDictionaryService latinDictionaryService;

    @Autowired
    public DictionaryController(@Qualifier("digitDictionaryServiceImpl") IDictionaryService digitDictionaryService,
                                @Qualifier("latinDictionaryServiceImpl") IDictionaryService latinDictionaryService) {
        this.digitDictionaryService = digitDictionaryService;
        this.latinDictionaryService = latinDictionaryService;
    }


    @PostMapping("/digit/add")
    public void add(@RequestParam String key, @RequestParam String value) {
        digitDictionaryService.add(key, value);
    }

    @DeleteMapping("/digit/delete")
    public void deleteDigitEntry(@RequestParam String key) {
        digitDictionaryService.delete(key);
    }

    @GetMapping("/digit/find")
    public Optional<String> findDigitEntry(@RequestParam String key) {
        return digitDictionaryService.findEntry(key);
    }

    @GetMapping("/digit/all")
    public String viewAllDigitEntries() {
        return digitDictionaryService.viewDictionaryContents();
    }


    @PostMapping("/latin/add")
    public void addLatinEntry(@RequestParam String key, @RequestParam String value) {
        latinDictionaryService.add(key, value);
    }

    @DeleteMapping("/latin/delete")
    public void deleteLatinEntry(@RequestParam String key) {
        latinDictionaryService.delete(key);
    }

    @GetMapping("/latin/find")
    public Optional<String> findLatinEntry(@RequestParam String key) {
        return latinDictionaryService.findEntry(key);
    }

    @GetMapping("/latin/all")
    public String viewAllLatinEntries() {
        return latinDictionaryService.viewDictionaryContents();
    }


//    @PostMapping("/digit/synonym/add")
//    public void addDigitSynonym(@RequestParam String word, @RequestParam String synonym) {
//        digitSynonymService.addSynonym(word, synonym);
//    }
//
//    @DeleteMapping("/digit/synonym/delete")
//    public void deleteDigitSynonym(@RequestParam String synonym) {
//        digitSynonymService.deleteSynonym(synonym);
//    }
//
//    @GetMapping("/digit/synonym/get")
//    public List<String> getDigitSynonyms(@RequestParam String word) {
//        return digitSynonymService.getSynonyms(word);
//    }
//
//    @PostMapping("/latin/synonym/add")
//    public void addLatinSynonym(@RequestParam String word, @RequestParam String synonym) {
//        latinSynonymService.addSynonym(word, synonym);
//    }
//
//    @DeleteMapping("/latin/synonym/delete")
//    public void deleteLatinSynonym(@RequestParam String synonym) {
//        latinSynonymService.deleteSynonym(synonym);
//    }
//
//    @GetMapping("/latin/synonym/get")
//    public List<String> getLatinSynonyms(@RequestParam String word) {
//        return latinSynonymService.getSynonyms(word);
//    }
}
