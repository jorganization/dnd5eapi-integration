package com.dnd5eapi_integration.model.spell;

import com.dnd5eapi_integration.model.Reference;
import com.dnd5eapi_integration.model.damage.Damage;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.HashMap;
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
    @JsonProperty("heal_at_slot_level")
    HashMap<String, String> healAtSlotLevel;
    @JsonProperty("area_of_effect")
    AreaOfEffect areaOfEffect;
    @JsonProperty("level")
    int level;
    @JsonProperty("attack_type")
    String attackType;
    @JsonProperty("damage")
    Damage damage;
    @JsonProperty("dc")
    DiceCheck dc;
    @JsonProperty("school")
    Reference school;
    @JsonProperty("classes")
    List<Reference> classes;
    @JsonProperty("subclasses")
    List<Reference> subclasses;
    @JsonProperty("url")
    String url;
}
