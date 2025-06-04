package com.medium.danieldiasjava.service;

import com.medium.danieldiasjava.model.entity.dto.CharacterDto;

import java.util.List;

public interface CharacterService {
    List<CharacterDto> getCharacters();
    CharacterDto getCharacter(String name);
    CharacterDto getCharacterEikon(String eikon);
    void saveCharacter(CharacterDto character);
}
