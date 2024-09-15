package com.dnd5eapi_integration.model.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
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
