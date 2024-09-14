package com.dnd5eapi_integration.model.spell;

import lombok.Data;

import java.util.List;

@Data
public class SpellsResults {
    int count;
    List<Result> results;

}
