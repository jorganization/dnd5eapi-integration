package com.dnd5eapi_integration.model.equipment;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Cost {
    @JsonProperty("quantity")
    int quantity;
    @JsonProperty("unit")
    String unit;
}
