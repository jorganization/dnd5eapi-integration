package com.dnd5eapi_integration.model.spell;

import com.dnd5eapi_integration.model.Reference;
import lombok.Data;

@Data
public class SpellDetail {
    Reference reference;
    Spell spell;
}
