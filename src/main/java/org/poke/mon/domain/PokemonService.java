package org.poke.mon.domain;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
/**
 * This interface is used as rest client
 * @author bruce
 */
@RegisterRestClient(configKey = "pokemon-api")
public interface PokemonService {
  
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPokemons(@QueryParam("limit") int limit);


    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPokemonByName(@PathParam String name);
}
