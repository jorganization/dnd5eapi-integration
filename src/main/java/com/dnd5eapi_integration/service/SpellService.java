package com.dnd5eapi_integration.service;

import com.dnd5eapi_integration.cleint.Dnd5eApiClient;
import com.dnd5eapi_integration.model.spell.Spell;
import com.dnd5eapi_integration.model.spell.SpellsResults;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@AllArgsConstructor
public class SpellService {
    Dnd5eApiClient dnd5eApiClient;
    ObjectMapper objectMapper;

    public String getSpells() {
       String result = "";
        try{
            Mono<String> monoResults = dnd5eApiClient.getSpellsResults();
//            monoResults.map(jsonString -> {
//            JsonNode root = objectMapper.readTree(jsonString);


//                log.info(spell.toString());
//                SpellsResults results = new SpellsResults();
//                results.setCount(spell.getCount());
//                results.setResults(spell.getResults());
//                log.info(results.toString());
//                return results;
//            });
        }catch (Exception ex) {
            log.error("Error Message: " + ex.getMessage());
        }




         return result;
    }


}
