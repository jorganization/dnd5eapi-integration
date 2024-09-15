package com.dnd5eapi_integration.model.damage;

import com.dnd5eapi_integration.model.Reference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.HashMap;

@Data
public class Damage {
    @JsonProperty("damage_type")
    Reference damageType;
    @JsonProperty("damage_at_slot_level")
    HashMap<String, String> damageAtSlotLevel;
    @JsonProperty("damage_at_character_level")
    HashMap<String, String> damageAtCharacterLevel;
}
