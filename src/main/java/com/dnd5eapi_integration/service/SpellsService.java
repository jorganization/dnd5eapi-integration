package com.dnd5eapi_integration.service;

import com.dnd5eapi_integration.cleint.Dnd5eApiClient;
import com.dnd5eapi_integration.model.spell.SpellReferences;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class SpellsService {
    Dnd5eApiClient dnd5eApiClient;

    public SpellReferences getSpells() {
        return dnd5eApiClient.getSpellReferences();
    }
    public SpellReferences getSpellsBySchool(String school) {
        return dnd5eApiClient.getSpellReferencesBySchool(school);
    }


}
