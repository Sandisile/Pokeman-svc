package org.poke.man.boundary;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import org.poke.man.domain.PokemanService;
import lombok.extern.slf4j.Slf4j;
import org.poke.man.domain.PokemonListResponse;
import org.poke.man.domain.PokemonResponse;

@Slf4j
@Path("/pokemon")
public class PokemanResource {

    @Inject
    @RestClient
    private PokemanService pokemanService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public PokemonListResponse getPokemons(@QueryParam("limit") int limit) {

       
        return this.pokemanService.getPokemons(limit).readEntity(PokemonListResponse.class);
        
    }
    

    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public PokemonResponse getPokemonByName(@PathParam String name) {
       
        return this.pokemanService.getPokemonByName(name).readEntity(PokemonResponse.class);
    }
}