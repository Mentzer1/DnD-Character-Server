package com.example.DnD_Character_Server;

import com.example.DnD_Character_Server.entities.*;
import com.example.DnD_Character_Server.entities.Character;
import com.example.DnD_Character_Server.exceptions.CharacterClassException;
import com.example.DnD_Character_Server.exceptions.GeneralExcepion;
import com.example.DnD_Character_Server.exceptions.RaceException;
import com.example.DnD_Character_Server.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    private CharacterService characterService = new CharacterService();

    @PostMapping("/character")
    public void addCharacter(@RequestBody Character character) {
        characterService.addCharacter(character);
    }

    @GetMapping("/character/{id}")
    public Character getOneCharacter(@PathVariable int id) {
        return characterService.getOneCharacter(id);
    }

    @GetMapping("/characters")
    public List<Character> getAllCharacters() {
        return characterService.getAllCharacters();
    }

    @PutMapping("/addclass")
    public void addClassToCharacter(@RequestBody CharacterClass characterClass) throws CharacterClassException {
        characterService.addClassToCharacter(characterClass);
    }

    @PutMapping("/addrace")
    public void addRaceToCharacter(@RequestBody Race race) throws RaceException {
        characterService.addRaceToCharacter(race);
    }

    @PutMapping("/addbackground")
    public void addBackgroundToCharacter(@RequestBody Background background) throws GeneralExcepion {
        characterService.addBackgroundToCharacter(background);
    }

    @PutMapping("/addfeat")
    public void addFeatToCharacter(@RequestBody Feat feat) throws GeneralExcepion {
        characterService.addFeatToCharacter(feat);
    }

    @PutMapping("/character")
    public void updateCharacter(@RequestBody Character character) throws CharacterClassException {
        characterService.updateCharacter(character);
    }

    @PutMapping("/addspell")
    public void addSpellToCharacter(@RequestBody Spell spell) throws GeneralExcepion {
        characterService.addSpellToCharacter(spell);
    }







}
