/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.poke.man.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author bruce
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonResponse {
    private Double height;
    @JsonProperty(value="held_items")
    private String[] heldItems;
    private Long id;
    @JsonProperty(value="is_default")
    private Boolean isDefault;
    @JsonProperty(value="sprites")
    private Sprite sprite;
}
