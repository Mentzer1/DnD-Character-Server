package com.example.DnD_Character_Server.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "classes")
public class CharacterClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private List<String> savingThrows;
    private int hitDieValue, subClassLevel;
    private List<Skill> proficiencies;
    @ManyToMany
    private List<Item> items;
    @ManyToMany
    private List<Weapon> weapons;
    @ManyToMany
    private List<Feature> features;
    @OneToMany(mappedBy = "classID", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<SubClass> subClasses;
}
