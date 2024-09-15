package com.dnd5eapi_integration.model.spell;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AreaOfEffect {
    @JsonProperty("type")
    String type;
    @JsonProperty("size")
    int size;
}
