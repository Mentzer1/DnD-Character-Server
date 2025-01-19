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
    @ManyToMany (fetch = FetchType.EAGER)
    private Set<Feat> feats;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Item> items;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Spell> spells;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Weapon> weapons;
    @OneToOne
    private Armor activeArmor;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Feature> features;


    public void setSkills(List<Skill> skills) {
        this.skills = Arrays.asList(Skill.values());
    }
}
