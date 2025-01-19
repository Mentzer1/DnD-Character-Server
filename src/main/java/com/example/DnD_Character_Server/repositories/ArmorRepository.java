package com.example.DnD_Character_Server.repositories;

import com.example.DnD_Character_Server.entities.Armor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArmorRepository extends JpaRepository<Armor, Integer> {
}
