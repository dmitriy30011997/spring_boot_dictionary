package com.dmitriy.dictionary_spring_boot.controllers.digit;

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
@RequestMapping("/dictionary/digit")
public class DigitDictionaryController {

    private final IDictionaryService digitDictionaryService;

    @Autowired
    public DigitDictionaryController(@Qualifier("digitDictionaryServiceImpl") IDictionaryService digitDictionaryService) {
        this.digitDictionaryService = digitDictionaryService;
    }


    @PostMapping("/add")
    public void add(String key, String value) {
        digitDictionaryService.add(key, value);
    }

    @DeleteMapping("/delete")
    public void deleteDigitEntry(@RequestParam String key) {
        digitDictionaryService.delete(key);
    }

    @GetMapping("/find")
    public Optional<String> findDigitEntry(@RequestParam String key) {
        return digitDictionaryService.findEntry(key);
    }

    @GetMapping("/all")
    public String viewAllDigitEntries() {
        return digitDictionaryService.viewDictionaryContents();
    }
}

