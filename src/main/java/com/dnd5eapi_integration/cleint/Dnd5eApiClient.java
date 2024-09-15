package com.dnd5eapi_integration.cleint;


import com.dnd5eapi_integration.model.spell.Spell;
import com.dnd5eapi_integration.model.spell.SpellDetail;
import com.dnd5eapi_integration.model.spell.SpellReferences;
import com.dnd5eapi_integration.property.ApplicationProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


@Slf4j
@Component
@AllArgsConstructor
public class Dnd5eApiClient {

    private ApplicationProperties applicationProperties;
    private ObjectMapper objectMapper;

    public SpellReferences getSpellReferences() {
        RestTemplate restTemplate = new RestTemplate();
        objectMapper = new ObjectMapper();
        SpellReferences spellReferences = new SpellReferences();
        ResponseEntity<String> response = restTemplate.getForEntity(getSpellsUri(), String.class);
        try {
            spellReferences = objectMapper.readValue(response.getBody(), SpellReferences.class);
        } catch (Exception ex) {
            log.error("Unable to create json object from String: {}\nWith Error Message:{}", response.getBody(), ex.getMessage());
        }
        log.info("Received Response: {}", spellReferences);
        return spellReferences;
    }
    private String getSpellsUri() {
        String url = UriComponentsBuilder.fromUriString(applicationProperties.getDnd5eApiUrl())
                .pathSegment("spells")
                .build()
                .toUriString();
        log.info("Making GET request: {}", url);
        return url;
    }


    public SpellReferences getSpellReferencesBySchool(String school) {
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper objectMapper = new ObjectMapper();
        SpellReferences spellReferences = new SpellReferences();
        ResponseEntity<String> response = restTemplate.getForEntity(getSpellsBySchoolUri(school), String.class);
        try {
            spellReferences = objectMapper.readValue(response.getBody(), SpellReferences.class);
        } catch (Exception ex) {
            log.error("Unable to create json object from String: {}\nWith Error Message:{}", response.getBody(), ex.getMessage());
        }
        log.info("Received Response: {}", spellReferences);
        return spellReferences;
    }
    private String getSpellsBySchoolUri(String name) {
        String url = UriComponentsBuilder.fromUriString(applicationProperties.getDnd5eApiUrl())
                .pathSegment("spells")
                .queryParam("school", name)
                .build()
                .toUriString();
        log.info("Making GET request: {}", url);
        return url;
    }


    public SpellReferences getSpellReferencesByLevel(int level) {
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper objectMapper = new ObjectMapper();
        SpellReferences spellReferences = new SpellReferences();
        ResponseEntity<String> response = restTemplate.getForEntity(getSpellsByLevelUri(level), String.class);
        try {
            spellReferences = objectMapper.readValue(response.getBody(), SpellReferences.class);
        } catch (Exception ex) {
            log.error("Unable to create json object from String: {}\nWith Error Message:{}", response.getBody(), ex.getMessage());
        }
        log.info("Received Response: {}", spellReferences);
        return spellReferences;
    }
    private String getSpellsByLevelUri(int level) {
        String url = UriComponentsBuilder.fromUriString(applicationProperties.getDnd5eApiUrl())
                .pathSegment("spells")
                .queryParam("level", level)
                .build()
                .toUriString();
        log.info("Making GET request: {}", url);
        return url;
    }


    public SpellReferences getSpellsBySchoolAndLevel(String school, int level) {
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper objectMapper = new ObjectMapper();
        SpellReferences spellReferences = new SpellReferences();
        ResponseEntity<String> response = restTemplate.getForEntity(getSpellsBySchoolAndLevelUri(school, level), String.class);
        try {
            spellReferences = objectMapper.readValue(response.getBody(), SpellReferences.class);
        } catch (Exception ex) {
            log.error("Unable to create json object from String: {}\nWith Error Message:{}", response.getBody(), ex.getMessage());
        }
        log.info("Received Response: {}", spellReferences);
        return spellReferences;
    }
    private String getSpellsBySchoolAndLevelUri(String school, int level) {
        String url = UriComponentsBuilder.fromUriString(applicationProperties.getDnd5eApiUrl())
                .pathSegment("spells")
                .queryParam("school", school)
                .queryParam("level", level)
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




