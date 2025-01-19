package com.example.DnD_Character_Server.repositories;

import com.example.DnD_Character_Server.entities.Character;
import com.example.DnD_Character_Server.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
