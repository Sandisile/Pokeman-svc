package org.poke.mon.boundary;

import java.util.Objects;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.poke.mon.domain.PokemonResponse;
import org.poke.mon.domain.Pokemon;
import lombok.extern.slf4j.Slf4j;
import org.poke.mon.domain.PokemonService;
/**
 *  This web service is used to get Pokemons 
 * @author bruce
 */
@Slf4j
@Path("/pokemon")
public class PokemonResource {

    @Inject
    @RestClient
    private PokemonService pokemonService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public PokemonResponse getPokemons(@QueryParam("limit") int limit) {

       log.info("about to get a list of pokemons limit: {}", limit);
        return this.pokemonService.getPokemons(limit).readEntity(PokemonResponse.class);
        
    }
    

    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public PokemonResponse getPokemonByName(@PathParam String name) {
      
        log.info("about to get pokemon by name: {}", name);
        Response response = this.pokemonService.getPokemonByName(name);
        Pokemon pokemon = (Objects.nonNull(response))? response.readEntity(Pokemon.class): null;
         
        return new PokemonResponse(null, pokemon);
    }
}