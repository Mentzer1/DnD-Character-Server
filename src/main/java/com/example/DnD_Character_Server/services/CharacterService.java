package com.example.DnD_Character_Server.services;

import com.example.DnD_Character_Server.entities.*;
import com.example.DnD_Character_Server.entities.Character;
import com.example.DnD_Character_Server.exceptions.CharacterClassException;
import com.example.DnD_Character_Server.exceptions.GeneralExcepion;
import com.example.DnD_Character_Server.exceptions.RaceException;
import com.example.DnD_Character_Server.repositories.CharacterClassRepository;
import com.example.DnD_Character_Server.repositories.CharacterRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class CharacterService {

    private int characterID;
    private CharacterRepository characterRepository;
    private CharacterClassRepository characterClassRepository;




    public void addCharacter(Character character){
        characterRepository.save(character);
    }

    public Character getCharacterDetails(){
        return characterRepository.findById(characterID).orElseThrow();
    }

    public void addClassToCharacter(CharacterClass characterClass) throws CharacterClassException {
        Character character = getCharacterDetails();
        if (character.getClassName() != null){
            throw new CharacterClassException("Character already has a class");
        }
        character.setClassName(characterClass.getName()); //set a class
        character.setSavingThrows(characterClass.getSavingThrows()); //set its saving throws
        character.setHitDieValue(characterClass.getHitDieValue()); // set its hit die value

        List<Skill> characterProfs = character.getProficiencies(); // make a list of character proficiencies
        characterProfs.addAll(characterClass.getProficiencies()); // add all additional profs from class
        character.setProficiencies(characterProfs); // set the updated list of profs

        List<Item> characterItems = character.getItems();
        characterItems.addAll(characterClass.getItems()); //same but with items
        character.setItems(characterItems);

        List<Weapon> characterWeapons = character.getWeapons();
        characterWeapons.addAll(characterClass.getWeapons()); // same but with weapons
        character.setWeapons(characterWeapons);

        List<Feature> characterFeatures = character.getFeatures();
        characterFeatures.addAll(characterClass.getFeatures());// same but with features
        character.setFeatures(characterFeatures);

        characterRepository.save(character);
    }

    public void addRaceToCharacter(Race race) throws RaceException {
        Character character = getCharacterDetails();
        if (character.getRaceName() != null){
            throw new RaceException("Character already has a race");
        }

        character.setRaceName(race.getName());
        character.setSpeed(race.getSpeed());

        List<Feature> characterFeatures = character.getFeatures();
        characterFeatures.addAll(race.getFeatures());// set the features
        character.setFeatures(characterFeatures);

        List<String> characterLanguages = character.getLanguages();
        characterLanguages.addAll(race.getLanguages());// same but with languages
        character.setLanguages(characterLanguages);
        
        characterRepository.save(character);
    }

    public void addBackgroundToCharacter(Background background) throws GeneralExcepion {
        Character character = getCharacterDetails();
        if (character.getBackgroundName() != null){
            throw new GeneralExcepion("Character already has a race");
        }

        List<Skill> characterProfs = character.getProficiencies(); // make a list of character proficiencies
        characterProfs.addAll(background.getProficiencies()); // add all additional profs from class
        character.setProficiencies(characterProfs); // set the updated list of profs

        character.setGp(background.getGp());

        List<Item> characterItems = character.getItems();
        characterItems.addAll(background.getItems()); //same but with items
        character.setItems(characterItems);

        List<String> characterLanguages = character.getLanguages();
        characterLanguages.addAll(background.getLanguages());
        character.setLanguages(characterLanguages);

        characterRepository.save(character);

    }

    public void addFeat(Feat feat) throws GeneralExcepion {
        Character character = getCharacterDetails();
        Set<Feat> feats = character.getFeats();
        if (feats.contains(feat)){
            throw new GeneralExcepion("Cant have more than 1 of the same feat!!!");
        } else {
            feats.add(feat);
            character.setFeats(feats);
            characterRepository.save(character);
        }
    }

    public void updateCharacter(Character character){

        characterRepository.save(character);
    }

    public void addSpell(Spell spell) throws GeneralExcepion {
        Character character = getCharacterDetails();
        Set<Spell> spells = character.getSpells();
        if (spells.contains(spell)){
            throw new GeneralExcepion("Cant have more than 1 of the same spell!!!");
        } else {
            spells.add(spell);
            character.setSpells(spells);
            characterRepository.save(character);
        }
    }


}
