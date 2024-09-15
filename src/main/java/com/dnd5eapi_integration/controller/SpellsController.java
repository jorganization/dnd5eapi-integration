package com.dnd5eapi_integration.controller;

import com.dnd5eapi_integration.cleint.SpellsClient;
import com.dnd5eapi_integration.model.spell.SpellDetail;
import com.dnd5eapi_integration.service.SpellsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("spells")
@AllArgsConstructor
public class SpellsController {

    SpellsClient spellsClient;
    SpellsService spellsService;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    public List<SpellDetail> getSpells() {
        log.info("getSpells");
        return spellsService.getSpellReferences(Optional.empty(), Optional.empty(), Optional.empty());
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(params = {"school"},method = RequestMethod.GET)
    public List<SpellDetail> getSpellsBySchool(@RequestParam("school") String school) {
        log.info("getSpellsBySchool");
        return spellsService.getSpellReferences(Optional.of(school), Optional.empty(), Optional.empty() );
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(params = {"level"},method = RequestMethod.GET)
    public List<SpellDetail> getSpellsByLevel(@RequestParam("level") int level) {
        log.info("getSpellsByLevel");
        return spellsService.getSpellReferences(Optional.empty(), Optional.of(level), Optional.empty());
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(params = {"school", "level"},method = RequestMethod.GET)
    public List<SpellDetail> getSpellBySchoolAndLevel(@RequestParam("level") int level, @RequestParam("school") String school) {
        log.info("getSpellBySchoolAndLevel");
        return spellsService.getSpellReferences(Optional.of(school), Optional.of(level), Optional.empty());
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(params = { "name" }, method = RequestMethod.GET)
    public SpellDetail getSpellDetailBySpellIndex(@RequestParam("name") String spellName) {
        log.info("getSpellDetailBySpellIndex");
        return spellsService.getSpellDetailByName(spellName);
    }

}