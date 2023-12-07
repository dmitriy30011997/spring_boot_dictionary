package com.dmitriy.dictionary_spring_boot.controllers;

import com.dmitriy.dictionary_spring_boot.dictionaries.services.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/dictionary")
public class LatinDictionaryController {

    private final IDictionaryService latinDictionaryService;

    @Autowired
    public LatinDictionaryController(@Qualifier("latinDictionaryServiceImpl") IDictionaryService latinDictionaryService) {
        this.latinDictionaryService = latinDictionaryService;
    }

    @PostMapping("/latin/add")
    public void addLatin(@RequestParam String key, @RequestParam String value) {
        latinDictionaryService.add(key, value);
    }

    @DeleteMapping("/latin/delete")
    public void deleteLatin(@RequestParam String key) {
        latinDictionaryService.delete(key);
    }

    @GetMapping("/latin/find")
    public Optional<String> findLatin(@RequestParam String key) {
        return latinDictionaryService.findEntry(key);
    }

    @GetMapping("/latin/all")
    public String viewAllLatin() {
        return latinDictionaryService.viewDictionaryContents();
    }
}