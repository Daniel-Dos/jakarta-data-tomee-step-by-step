package com.medium.danieldiasjava.controller;

import com.medium.danieldiasjava.model.entity.dto.CharacterDto;
import com.medium.danieldiasjava.service.CharacterService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Objects;

@Path("characters")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CharacterController {

    private CharacterService characterService;

    public CharacterController() {}

    @Inject
    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GET
    public Response getCharacters(@QueryParam("name") String name, @QueryParam("eikon") String eikon) {
        if (name != null && !name.isEmpty()) {
            var character = characterService.getCharacter(name);
            return Response.ok(character).build();
        }
        if (eikon != null && !eikon.isEmpty()) {
            var character = characterService.getCharacterEikon(eikon);
            return Response.ok(character).build();
        }
        List<CharacterDto> characters = characterService.getCharacters();
        return (Objects.nonNull(characters) && !characters.isEmpty() ?
                Response.status(Response.Status.OK).entity(characters).build() :
                Response.status(Response.Status.NO_CONTENT).entity("Characters not found").build());
    }

    @POST
    public Response createCharacter(CharacterDto character) {

        if(Objects.nonNull(character)) {
            characterService.saveCharacter(character);
            return Response.status(Response.Status.CREATED).entity(character).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).entity("Character cannot be null").build();
        }
    }
}
