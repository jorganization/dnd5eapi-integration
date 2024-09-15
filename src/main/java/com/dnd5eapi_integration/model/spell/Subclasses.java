package com.dnd5eapi_integration.model.spell;

import com.dnd5eapi_integration.model.Reference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Subclasses {
    @JsonProperty()
    List<Reference> references;
}
