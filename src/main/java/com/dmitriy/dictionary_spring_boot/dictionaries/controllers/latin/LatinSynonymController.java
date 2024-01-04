package com.dmitriy.dictionary_spring_boot.controllers.latin;

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
@RequestMapping("/dictionary/latin/synonym")
@Tag(name = "Latin synonym Dictionary", description = "Operations related to latin synonym  dictionary")
public class LatinSynonymController {

    private final ISynonymService latinSynonymService;

    @Autowired
    public LatinSynonymController(@Qualifier("latinSynonymService") ISynonymService latinSynonymService) {
        this.latinSynonymService = latinSynonymService;
    }

    @PostMapping("/add")
    @Operation(summary = "Add synonym")
    public void addLatinSynonym(@RequestParam String word, @RequestParam String synonym) {
        latinSynonymService.addSynonym(word, synonym);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Delete synonym")
    public void deleteLatinSynonym(@RequestParam String synonym) {
        latinSynonymService.deleteSynonym(synonym);
    }

    @GetMapping("/get")
    @Operation(summary = "Get synonyms")
    public List<String> getLatinSynonyms(@RequestParam String word) {
        return latinSynonymService.getSynonyms(word);
    }
}
