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

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public SpellReferences getSpells() {
        return spellsService.getSpells();
    }

    @GetMapping(value = "/{name}")
    @ResponseStatus(HttpStatus.OK)
    public String helloName(@PathVariable("name") String name) {
        String greeting = "Hello " + name;
        log.info(greeting);
        return greeting;
    }

}
