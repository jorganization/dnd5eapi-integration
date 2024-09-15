package com.dnd5eapi_integration.model.spell;

import com.dnd5eapi_integration.model.common.Reference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class SpellReferences {
    @JsonProperty("count")
    int count;
    @JsonProperty("results")
    List<Reference> references;

}
