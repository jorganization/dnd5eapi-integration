package com.dnd5eapi_integration.model.equipment;

import com.dnd5eapi_integration.model.common.Reference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Equipment {
    @JsonProperty("desc")
    String description;
    @JsonProperty("special")
    String special;
    @JsonProperty("index")
    String index;
    @JsonProperty("name")
    String name;
    @JsonProperty("equipment_category")
    Reference equipmentCategory;
    @JsonProperty("str_minimum")
    int strengthMinimum;
    @JsonProperty("stealth_disadvantage")
    boolean stealthDisadvantage;
    @JsonProperty("weight")
    int weight;
    @JsonProperty("cost")
    Cost cost;
    @JsonProperty("url")
    String url;
    @JsonProperty("contents")
    Reference contents;
    @JsonProperty("properties")
    Reference properties;
}
