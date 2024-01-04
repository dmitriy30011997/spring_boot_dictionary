package com.dmitriy.dictionary_spring_boot.controllers.digit;

import com.dmitriy.dictionary_spring_boot.synonyms.services.ISynonymService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dictionary/digit/synonym")
@Tag(name = "Digit Synonym", description = "Operations related to digit synonym dictionary")
public class DigitSynonymController {

    private final ISynonymService digitSynonymService;

    @Autowired
    public DigitSynonymController(@Qualifier("digitSynonymService") ISynonymService digitSynonymService) {
        this.digitSynonymService = digitSynonymService;
    }

    @PostMapping("/add")
    @Operation(summary = "Add synonym")
    public void addDigitSynonym(@RequestParam String word, @RequestParam String synonym) {
        digitSynonymService.addSynonym(word, synonym);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Delete synonym")
    public void deleteDigitSynonym(@RequestParam String synonym) {
        digitSynonymService.deleteSynonym(synonym);
    }

    @GetMapping("/get")
    @Operation(summary = "Get synonyms")
    public List<String> getDigitSynonyms(@RequestParam String word) {
        return digitSynonymService.getSynonyms(word);
    }
}
