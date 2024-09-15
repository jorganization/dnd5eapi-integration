package com.dnd5eapi_integration.cleint;


import com.dnd5eapi_integration.model.spell.Spell;
import com.dnd5eapi_integration.model.spell.SpellReferences;
import com.dnd5eapi_integration.property.ApplicationProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;


@Slf4j
@Component
@AllArgsConstructor
public class Dnd5eApiClient {

    private ApplicationProperties applicationProperties;
    private ObjectMapper objectMapper;

    public SpellReferences getSpellReference(Optional<String> school, Optional<Integer> level, Optional<String> name) {
        RestTemplate restTemplate = new RestTemplate();
        objectMapper = new ObjectMapper();
        SpellReferences spellReferences = new SpellReferences();
        ResponseEntity<String> response = restTemplate.getForEntity(buildSpellReferenceUrl(school, level), String.class);
        try {
            spellReferences = objectMapper.readValue(response.getBody(), SpellReferences.class);
        } catch (Exception ex) {
            log.error("Unable to create json object from String: {}\nWith Error Message:{}", response.getBody(), ex.getMessage());
        }
        log.info("Received Response: {}", spellReferences);
        return spellReferences;
    }
    private String buildSpellReferenceUrl(Optional<String> school, Optional<Integer> level) {
        String url = UriComponentsBuilder.fromUriString(applicationProperties.getDnd5eApiUrl())
                .pathSegment("spells")
                .queryParamIfPresent("school", school)
                .queryParamIfPresent("level", level)
                .build()
                .toUriString();
        log.info("Making GET request: {}", url);
        return url;
    }

    public Spell getSpellDetailByIndex(String index) {
        RestTemplate restTemplate = new RestTemplate();
        objectMapper = new ObjectMapper();
        Spell spell = new Spell();
        ResponseEntity<String> response = restTemplate.getForEntity(getSpellDetailUri(index), String.class);
        try {
            spell = objectMapper.readValue(response.getBody(), Spell.class);
        } catch (Exception ex) {
            log.error("Unable to create json object from String: {}\nWith Error Message:{}", response.getBody(), ex.getMessage());
        }
        log.info("Received Response: {}", spell);
        return spell;
    }
    private String getSpellDetailUri(String spellName) {
        String url = UriComponentsBuilder.fromUriString(applicationProperties.getDnd5eApiUrl())
                .pathSegment("spells")
                .pathSegment(spellName)
                .build()
                .toUriString();
        log.info("Making GET request: {}", url);
        return url;
    }

}




