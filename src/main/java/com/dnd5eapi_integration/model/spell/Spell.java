package com.dnd5eapi_integration.model.spell;

import com.dnd5eapi_integration.model.damage.Damage;
import lombok.Data;

import java.util.List;

@Data
public class Spell {
    String index;
    String name;
    List<String> desc;
    List<String> higher_level;
    String range;
    List<String> components;
    String material;
    boolean ritual;
    String duration;
    boolean concentration;
    String casting_time;
    int level;
    String attackType;
    Damage damage;
    School school;
    Classes classes;
    Subclasses subclasses;
    String url;}
