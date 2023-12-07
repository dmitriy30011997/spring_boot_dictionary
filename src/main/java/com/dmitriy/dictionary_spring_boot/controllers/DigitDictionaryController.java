package com.dmitriy.dictionary_spring_boot.controllers;

import com.dmitriy.dictionary_spring_boot.dictionaries.services.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/dictionary")
public class DigitDictionaryController {

    private final IDictionaryService digitDictionaryService;

    @Autowired
    public DigitDictionaryController(@Qualifier("digitDictionaryServiceImpl") IDictionaryService digitDictionaryService) {
        this.digitDictionaryService = digitDictionaryService;
    }


    @PostMapping("/digit/add")
    public void add(String key, String value) {
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
}

