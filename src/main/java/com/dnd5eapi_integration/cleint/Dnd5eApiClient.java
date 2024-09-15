package com.dnd5eapi_integration.cleint;


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


    private String getSpellsUri() {
        String url = UriComponentsBuilder.fromUriString(applicationProperties.getDnd5eApiUrl())
                .pathSegment("spells")
                .build()
                .toUriString();
        log.info("Making GET request: {}", url);
        return url;
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

    private String getSpellsByLevelUri(int level) {
        String url = UriComponentsBuilder.fromUriString(applicationProperties.getDnd5eApiUrl())
                .pathSegment("spells")
                .queryParam("level", level)
                .build()
                .toUriString();
        log.info("Making GET request: {}", url);
        return url;
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

}




