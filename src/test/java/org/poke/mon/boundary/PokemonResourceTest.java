/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.poke.mon.boundary;

import io.quarkus.test.junit.QuarkusTest;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author bruce
 */
@QuarkusTest
public class PokemonResourceTest {
    

    /**
     * Test of getPokemons method, of class PokemanResource.
     */
    @Test
    public void shouldReturnListOftPokemons() {
        int limit = 1;
        Response response = 
                given()
               .when()
                .queryParam("limit", limit)
                .get("/api/pokemon");
                
                response
                        .then()
                       .statusCode(200);
               
                assertNotNull(response.body());
                response.body().print();
    }

    /**
     * Test of getPokemonByName method, of class PokemanResource.
     */
    @Test
    public void shouldGetPokemonByName() {
             
        Response response = 
                given()
               .when()
                .get("/api/pokemon/bulbasaur");
                
                response
                        .then()
                       .statusCode(200);
               
                assertNotNull(response.body());
                response.body().print();
    }
    
}
