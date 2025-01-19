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
@Table(name = "spells")
public class Spell {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name, castingTime, duration, description;
    private int level, spellRange;
    private String components;
    @ElementCollection
    @CollectionTable(name = "spell_classes", joinColumns = @JoinColumn(name = "spell_id"))
    @Column(name = "class_name")
    private List<String> classesNames;
    private SpellType spellType;
    private boolean ritual;

}
