package org.poke.man.domain;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RegisterRestClient(baseUri = "https://pokeapi.co/api/v2/pokemon")
public interface PokemanService {
  
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPokemons(@QueryParam("limit") int limit);


    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPokemonByName(@PathParam String name);
}
