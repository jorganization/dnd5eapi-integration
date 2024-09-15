package com.dnd5eapi_integration.service;

import com.dnd5eapi_integration.cleint.Dnd5eApiClient;
import com.dnd5eapi_integration.model.common.Reference;
import com.dnd5eapi_integration.model.spell.Spell;
import com.dnd5eapi_integration.model.spell.SpellDetail;
import com.dnd5eapi_integration.model.spell.SpellReferences;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
@AllArgsConstructor
public class SpellsService {

    Dnd5eApiClient dnd5eApiClient;

    public List<SpellDetail> getSpellReferences(Optional<String> school, Optional<Integer> level, Optional<String> name) {
        SpellReferences spellReferences = dnd5eApiClient.getSpellReference(school, level, name);
        return mapReferencesToSpellDetail(spellReferences.getReferences());
    }

    private List<SpellDetail> mapReferencesToSpellDetail(List<Reference> references) {
        List<SpellDetail> spellDetailList = new ArrayList<>();
        references.forEach(ref -> {
            SpellDetail spellDetail = new SpellDetail();
            spellDetail.setReference(ref);
            spellDetail.setSpell(getSpellDetailByName(ref.getIndex()).getSpell());
            spellDetailList.add(spellDetail);
        });
        return spellDetailList;
    }

    public SpellDetail getSpellDetailByName(String name) {
        Spell spell = dnd5eApiClient.getSpellDetailByIndex(name);

        Reference reference = new Reference();
        reference.setName(spell.getName());
        reference.setIndex(name);
        reference.setUrl(spell.getUrl());
        reference.setLevel(spell.getLevel());

        SpellDetail spellDetail = new SpellDetail();
        spellDetail.setSpell(spell);
        spellDetail.setReference(reference);

        return spellDetail;
    }

}
