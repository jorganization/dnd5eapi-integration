package com.dnd5eapi_integration.model.spell;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Reference {
    @JsonProperty("index")
    String index;
    @JsonProperty("name")
    String name;
    @JsonProperty("level")
    int level;
    @JsonProperty("url")
    String url;
}
