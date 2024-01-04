package com.dmitriy.dictionary_spring_boot.api.feigns;

import com.dmitriy.dictionary_spring_boot.api.dto.WordDefinition;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "dictionary-api", url = "${url-of-api}")
public interface DictionaryAPI {

    @GetMapping("/api/v2/entries/en/{word}")
    List<WordDefinition> getWordDefinition(@PathVariable String word);
}