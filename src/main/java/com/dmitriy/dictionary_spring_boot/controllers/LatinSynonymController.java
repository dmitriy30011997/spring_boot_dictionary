package com.dmitriy.dictionary_spring_boot.controllers;

import com.dmitriy.dictionary_spring_boot.synonyms.services.ISynonymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dictionary/latin/synonym")
public class LatinSynonymController {

    private final ISynonymService latinSynonymService;

    @Autowired
    public LatinSynonymController(@Qualifier("latinSynonymService") ISynonymService latinSynonymService) {
        this.latinSynonymService = latinSynonymService;
    }

    @PostMapping("/add")
    public void addLatinSynonym(@RequestParam String word, @RequestParam String synonym) {
        latinSynonymService.addSynonym(word, synonym);
    }

    @DeleteMapping("/delete")
    public void deleteLatinSynonym(@RequestParam String synonym) {
        latinSynonymService.deleteSynonym(synonym);
    }

    @GetMapping("/get")
    public List<String> getLatinSynonyms(@RequestParam String word) {
        return latinSynonymService.getSynonyms(word);
    }
}
