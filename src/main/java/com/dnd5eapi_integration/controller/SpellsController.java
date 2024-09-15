package com.dnd5eapi_integration.controller;

import com.dnd5eapi_integration.cleint.Dnd5eApiClient;
import com.dnd5eapi_integration.model.spell.SpellReferences;
import com.dnd5eapi_integration.service.SpellsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/spells")
@AllArgsConstructor
public class SpellsController {

    Dnd5eApiClient dnd5eApiClient;
    SpellsService spellsService;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    public SpellReferences getSpells() {
        return spellsService.getSpells();
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(params = {"school"},method = RequestMethod.GET)
    public SpellReferences getSpellsBySchool(@RequestParam("school") String school) {
        return spellsService.getSpellsBySchool(school);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(params = {"level"},method = RequestMethod.GET)
    public SpellReferences getSpellsByLevel(@RequestParam("level") int level) {
        return spellsService.getSpellsByLevel(level);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(params = {"school", "level"},method = RequestMethod.GET)
    public SpellReferences getSpellsBySchoolAndLevel(@RequestParam("level") int level, @RequestParam("school") String school) {
        return spellsService.getSpellsBySchoolAndLevel(school, level);
    }

}
