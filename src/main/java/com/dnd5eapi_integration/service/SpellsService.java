package com.dnd5eapi_integration.service;

import com.dnd5eapi_integration.cleint.Dnd5eApiClient;
import com.dnd5eapi_integration.model.Reference;
import com.dnd5eapi_integration.model.spell.Spell;
import com.dnd5eapi_integration.model.spell.SpellDetail;
import com.dnd5eapi_integration.model.spell.SpellReferences;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
@AllArgsConstructor
public class SpellsService {
    Dnd5eApiClient dnd5eApiClient;

    public List<SpellDetail> getSpells() {
        SpellReferences spellReferences = dnd5eApiClient.getSpellReferences();
        return mapReferencesToSpellDetail(spellReferences.getReferences());
    }
    public List<SpellDetail> getSpellsBySchool(String school) {
        SpellReferences spellReferences = dnd5eApiClient.getSpellReferencesBySchool(school);
        return mapReferencesToSpellDetail(spellReferences.getReferences());
    }
    public List<SpellDetail> getSpellsByLevel(int level) {

        SpellReferences spellReferences = dnd5eApiClient.getSpellReferencesByLevel(level);
        return mapReferencesToSpellDetail(spellReferences.getReferences());
    }

    public List<SpellDetail> getSpellsBySchoolAndLevel(String school, int level) {
        SpellReferences spellReferences = dnd5eApiClient.getSpellsBySchoolAndLevel(school, level);
        return mapReferencesToSpellDetail(spellReferences.getReferences());
    }

    public Spell getSpellDetailByName(String index) {
        return dnd5eApiClient.getSpellDetailByIndex(index);
    }

    private List<SpellDetail> mapReferencesToSpellDetail(List<Reference> references) {
        List<SpellDetail> spellDetailList = new ArrayList<>();
        references.forEach(ref -> {
            SpellDetail spellDetail = new SpellDetail();
            spellDetail.setReference(ref);
            spellDetail.setSpell(getSpellDetailByName(ref.getIndex()));
            spellDetailList.add(spellDetail);
        });
        return spellDetailList;
    }

}
