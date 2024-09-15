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

import static com.dnd5eapi_integration.constants.Constants.*;


@Slf4j
@Component
@AllArgsConstructor
public class Dnd5eApiClient {

    private ApplicationProperties applicationProperties;
    private ObjectMapper objectMapper;

    public SpellReferences getSpellReference(Optional<String> school, Optional<Integer> level, Optional<String> spellName) {
        RestTemplate restTemplate = new RestTemplate();
        objectMapper = new ObjectMapper();
        SpellReferences spellReferences = new SpellReferences();
        ResponseEntity<String> response = restTemplate.getForEntity(buildSpellReferenceUrl(school, level), String.class);
        try {
            spellReferences = objectMapper.readValue(response.getBody(), SpellReferences.class);
        } catch (Exception ex) {
            log.error(EXCEPTION_CAUGHT_WITH_MESSAGE, ex.getMessage());
        }
        log.info(RESPONSE, spellReferences);
        return spellReferences;
    }

    public Spell getSpellDetailByIndex(String spellName) {
        RestTemplate restTemplate = new RestTemplate();
        objectMapper = new ObjectMapper();
        Spell spell = new Spell();
        ResponseEntity<String> response = restTemplate.getForEntity(getSpellDetailUri(spellName), String.class);
        try {
            spell = objectMapper.readValue(response.getBody(), Spell.class);
        } catch (Exception ex) {
            log.error(EXCEPTION_CAUGHT_WITH_MESSAGE, ex.getMessage());
        }
        log.info(RESPONSE, spell);
        return spell;
    }

    private String buildSpellReferenceUrl(Optional<String> school, Optional<Integer> level) {
        String url = "";
        try {
            url = UriComponentsBuilder.fromUriString(applicationProperties.getDnd5eApiUrl())
                    .pathSegment(SPELLS)
                    .queryParamIfPresent(SCHOOL, school)
                    .queryParamIfPresent(LEVEL, level)
                    .build()
                    .toUriString();
            log.info(GET, url);
        } catch (Exception ex) {
            log.error(EXCEPTION_CAUGHT_WITH_MESSAGE, ex.getMessage());
        }
        return url;
    }

    private String getSpellDetailUri(String spellName) {
        String url = "";
        try {
            url = UriComponentsBuilder.fromUriString(applicationProperties.getDnd5eApiUrl())
                    .pathSegment(SPELLS)
                    .pathSegment(spellName)
                    .build()
                    .toUriString();
            log.info(GET, url);
        } catch (Exception ex) {
            log.error(EXCEPTION_CAUGHT_WITH_MESSAGE, ex.getMessage());
        }
        return url;
    }

}




