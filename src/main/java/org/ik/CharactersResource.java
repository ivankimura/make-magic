package org.ik;

import org.ik.dto.CharRequest;
import org.ik.dto.Houses;
import org.ik.entity.CharacterEntity;
import org.ik.service.CharactersService;
import org.ik.service.HousesService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@Path("/api/characters")
public class CharactersResource {

    HousesService service;
    CharactersService charactersService;

    public CharactersResource(HousesService service, CharactersService charactersService) {

        this.service = service;
        this.charactersService = charactersService;
    }


    @GET
    @Path("/houses")
    @Produces(MediaType.APPLICATION_JSON)
    public Response queryHouses() {
        return service.retrieveHouses().map(result -> Response.ok().entity(result).build()).orElse(Response.status(Response.Status.BAD_GATEWAY).build());
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(CharRequest charRequest){
        CharacterEntity result = charactersService.insert(charRequest);

        return Response.ok().entity(result).build();
    }



}