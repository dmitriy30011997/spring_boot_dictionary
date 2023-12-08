package com.dmitriy.dictionary_spring_boot.controllers.latin;

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
@RequestMapping("/dictionary/latin")
public class LatinDictionaryController {

    private final IDictionaryService latinDictionaryService;

    @Autowired
    public LatinDictionaryController(@Qualifier("latinDictionaryServiceImpl") IDictionaryService latinDictionaryService) {
        this.latinDictionaryService = latinDictionaryService;
    }

    @PostMapping("/add")
    public void addLatin(@RequestParam String key, @RequestParam String value) {
        latinDictionaryService.add(key, value);
    }

    @DeleteMapping("/delete")
    public void deleteLatin(@RequestParam String key) {
        latinDictionaryService.delete(key);
    }

    @GetMapping("/find")
    public Optional<String> findLatin(@RequestParam String key) {
        return latinDictionaryService.findEntry(key);
    }

    @GetMapping("/all")
    public String viewAllLatin() {
        return latinDictionaryService.viewDictionaryContents();
    }
}