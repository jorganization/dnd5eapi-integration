package com.dnd5eapi_integration.controller;

import com.dnd5eapi_integration.cleint.Dnd5eApiClient;
import com.dnd5eapi_integration.model.spell.Spell;
import com.dnd5eapi_integration.model.spell.SpellDetail;
import com.dnd5eapi_integration.model.spell.SpellReferences;
import com.dnd5eapi_integration.service.SpellsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("spells")
@AllArgsConstructor
public class SpellsController {

    Dnd5eApiClient dnd5eApiClient;
    SpellsService spellsService;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    public List<SpellDetail> getSpells() {
        log.info("getSpells");
        return spellsService.getSpells();
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(params = {"school"},method = RequestMethod.GET)
    public List<SpellDetail> getSpellsBySchool(@RequestParam("school") String school) {
        log.info("getSpellsBySchool");
        return spellsService.getSpellsBySchool(school);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(params = {"level"},method = RequestMethod.GET)
    public List<SpellDetail> getSpellsByLevel(@RequestParam("level") int level) {
        log.info("getSpellsByLevel");
        return spellsService.getSpellsByLevel(level);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(params = {"school", "level"},method = RequestMethod.GET)
    public List<SpellDetail> getSpellBySchoolAndLevel(@RequestParam("level") int level, @RequestParam("school") String school) {
        log.info("getSpellBySchoolAndLevel");
        return spellsService.getSpellsBySchoolAndLevel(school, level);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(params = { "name" }, method = RequestMethod.GET)
    public Spell getSpellDetailBySpellIndex(@RequestParam("name") String spellName) {
        log.info("getSpellDetailBySpellIndex");
        return spellsService.getSpellDetailByName(spellName);
    }


}