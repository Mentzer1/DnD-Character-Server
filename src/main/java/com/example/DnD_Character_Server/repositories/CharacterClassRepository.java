package com.example.DnD_Character_Server.repositories;

import com.example.DnD_Character_Server.entities.CharacterClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterClassRepository extends JpaRepository<CharacterClass, Integer> {
}
