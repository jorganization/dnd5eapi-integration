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

    public SpellReferences getSpellReferences() {
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper objectMapper = new ObjectMapper();
        SpellReferences spellReferences = new SpellReferences();
        ResponseEntity<String> response = restTemplate.getForEntity(getSpellUri(), String.class);
        try {
            spellReferences = objectMapper.readValue(response.getBody(), SpellReferences.class);
        } catch (Exception ex) {
            log.error("Unable to create json object from String: {}\nWith Error Message:{}", response.getBody(), ex.getMessage());
        }
        log.info("Received Response: {}", spellReferences);
        return spellReferences;
    }


    private String getSpellUri() {
        String url = UriComponentsBuilder.fromUriString(applicationProperties.getDnd5eApiUrl())
                .pathSegment("spells")
                .build()
                .toUriString();
        log.info("Making GET request: {}", url);
        return url;
    }

}

