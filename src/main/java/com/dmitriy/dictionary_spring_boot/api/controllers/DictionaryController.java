package com.dmitriy.dictionary_spring_boot.api.controllers;

import com.dmitriy.dictionary_spring_boot.api.dto.WordDefinition;
import com.dmitriy.dictionary_spring_boot.api.services.DictionaryAPIService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/dictionary")
public class DictionaryController {

    private final DictionaryAPIService dictionaryService;

    public DictionaryController(DictionaryAPIService dictionaryService) {
        this.dictionaryService = dictionaryService;
    }

    @GetMapping("/definition/{word}")
    public ResponseEntity getWordDefinition(@PathVariable String word) {
        List<WordDefinition> definitions = dictionaryService.getWordDefinition(word);
        if (!CollectionUtils.isEmpty(definitions)) {
            return new ResponseEntity(definitions, HttpStatus.OK);
        } else {
            return new ResponseEntity("Definition not found", HttpStatus.NOT_FOUND);
        }
    }
}
