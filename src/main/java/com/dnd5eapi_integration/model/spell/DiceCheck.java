package com.dnd5eapi_integration.model.spell;

import com.dnd5eapi_integration.model.common.Reference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DiceCheck {
    @JsonProperty("dc_type")
    Reference dcType;
    @JsonProperty("dc_success")
    String dcSuccess;
    @JsonProperty("desc")
    String description;

}
