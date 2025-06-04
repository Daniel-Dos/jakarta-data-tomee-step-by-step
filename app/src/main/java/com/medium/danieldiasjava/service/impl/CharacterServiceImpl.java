package com.medium.danieldiasjava.service.impl;

import com.medium.danieldiasjava.model.entity.dto.CharacterDto;
import com.medium.danieldiasjava.repository.CharacterRepository;
import com.medium.danieldiasjava.service.CharacterService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Objects;

@RequestScoped
public class CharacterServiceImpl implements CharacterService {

    private CharacterRepository characterRepository;

    public CharacterServiceImpl(){}

    @Inject
    public CharacterServiceImpl(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @Override
    public List<CharacterDto> getCharacters() {
        var characters = characterRepository.findCharacters();
        if (Objects.nonNull(characters) && !characters.isEmpty()) {
            return CharacterDto.EntityListFromDtoList(characters);
        }
        return List.of();
    }

    @Override
    public CharacterDto getCharacter(String name) {
        if (Objects.nonNull(name) && !name.isEmpty()) {
            var character = characterRepository.findCharacterByName(name);
            if (character != null) {
                return CharacterDto.EntityFromDto(character);
            }
        }
        return new CharacterDto("","", false);
    }

    @Override
    public CharacterDto getCharacterEikon(String eikon) {
        if (Objects.nonNull(eikon) && !eikon.isEmpty()) {
            var character = characterRepository.characterByEikon(eikon);
            if (character != null) {
                return CharacterDto.EntityFromDto(character);
            }
        }
        return new CharacterDto("","", false);
    }

    @Override
    public void saveCharacter(CharacterDto character) {
        if (Objects.nonNull(character)) {
            characterRepository.saveCharacter(
                    CharacterDto.dtoFromEntity(character)
            );
        } else {
            throw new IllegalArgumentException("Character cannot be null");
        }
    }
}