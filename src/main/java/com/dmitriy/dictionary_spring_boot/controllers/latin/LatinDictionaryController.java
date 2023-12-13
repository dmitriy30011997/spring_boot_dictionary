package com.dmitriy.dictionary_spring_boot.controllers.latin;

import com.dmitriy.dictionary_spring_boot.dictionaries.services.IDictionaryService;
import com.dmitriy.dictionary_spring_boot.entities.LatinEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/dictionary/latin")
@Tag(name = "Latin Dictionary", description = "Operations related to latin dictionary")
public class LatinDictionaryController {

    private final IDictionaryService latinDictionaryService;

    @Autowired
    public LatinDictionaryController(@Qualifier("latinDictionaryServiceImpl") IDictionaryService latinDictionaryService) {
        this.latinDictionaryService = latinDictionaryService;
    }

    @PostMapping("/add")
    @Operation(summary = "Add entry")
    public void addLatin(@RequestParam String key, @RequestParam String value) {
        latinDictionaryService.add(key, value);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Delete entry")
    public void deleteLatin(@RequestParam String key) {
        latinDictionaryService.delete(key);
    }

    @GetMapping("/find")
    @Operation(summary = "Find entry")
    public Optional<String> findLatin(@RequestParam String key) {
        return latinDictionaryService.findEntry(key);
    }

    @GetMapping("/all")
    @Operation(summary = "View all entries with pagination")
    public Page<LatinEntity> viewAllLatin(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return latinDictionaryService.viewDictionaryContents(page, size);
    }
}