package com.medium.danieldiasjava.repository;

import com.medium.danieldiasjava.model.entity.FfCharacter;
import jakarta.data.repository.Find;
import jakarta.data.repository.Insert;
import jakarta.data.repository.Query;
import jakarta.data.repository.Repository;

import java.util.List;

@Repository
public interface CharacterRepository {

    @Find
    FfCharacter findCharacterByName(String name);
    @Query("where eikon = ?1")
    FfCharacter characterByEikon(String eikon);
    @Find
     List<FfCharacter> findCharacters();
    @Insert
     void saveCharacter(FfCharacter character);

}
