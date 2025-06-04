package com.medium.danieldiasjava.model.entity.dto;

import com.medium.danieldiasjava.model.entity.FfCharacter;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public record CharacterDto(
        String name,
        String eikon,
        boolean dominant ) implements Serializable {

    public static FfCharacter dtoFromEntity(CharacterDto dto) {
        return new FfCharacter(
                dto.name,
                dto.eikon,
                dto.dominant
        );
    }

    public static List<CharacterDto> EntityListFromDtoList(List<FfCharacter> entity) {
        return entity.stream()
                .map(CharacterDto::EntityFromDto)
                .collect(Collectors.toList());
    }

    public static CharacterDto EntityFromDto(FfCharacter ffCharacter) {
        return new CharacterDto(
                ffCharacter.getName(),
                ffCharacter.getEikon(),
                ffCharacter.isDominant()
        );
    }
}