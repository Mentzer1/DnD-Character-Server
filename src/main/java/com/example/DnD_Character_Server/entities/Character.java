package com.example.DnD_Character_Server.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "characters")
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name, image, gender, age, description, className, raceName, backgroundName;
    private int level, maxHP, currentHP, tempHp, armorClass, proficiencyBonus, speed, initiativeBonus, hitDieValue, maxHitDice,
            currentHitDice, passivePerception;
    private boolean inspiration, shield;
    private Alignment alignment;
    private int str, dex, con, intel, wis, cha;
    private int cp,sp,gp,pp;
    private List<String> savingThrows, languages;
    private List<Skill> skills, proficiencies;
    @ManyToMany
    private Set<Feat> feats;
    @ManyToMany
    private List<Item> items;
    @ManyToMany
    private Set<Spell> spells;
    @ManyToMany
    private List<Weapon> weapons;
    @OneToOne
    private Armor activeArmor;
    @ManyToMany
    private List<Feature> features;


    public void setSkills(List<Skill> skills) {
        this.skills = Arrays.asList(Skill.values());
    }
}
