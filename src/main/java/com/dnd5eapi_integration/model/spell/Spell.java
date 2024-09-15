package com.dnd5eapi_integration.model.spell;

import com.dnd5eapi_integration.model.damage.Damage;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Spell {
    @JsonProperty("index")
    String index;
    @JsonProperty("name")
    String name;
    @JsonProperty("desc")
    List<String> desc;
    @JsonProperty("higher_level")
    List<String> higherLevel;
    @JsonProperty("range")
    String range;
    @JsonProperty("components")
    List<String> components;
    @JsonProperty("material")
    String material;
    @JsonProperty("ritual")
    boolean ritual;
    @JsonProperty("duration")
    String duration;
    @JsonProperty("concentration")
    boolean concentration;
    @JsonProperty("casting_time")
    String castingTime;
    @JsonProperty("level")
    int level;
    @JsonProperty("attackType")
    String attackType;
    @JsonProperty("damage")
    Damage damage;
    @JsonProperty("school")
    School school;
    @JsonProperty("classes")
    Classes classes;
    @JsonProperty("subclasses")
    Subclasses subclasses;
    @JsonProperty("url")
    String url;
}
