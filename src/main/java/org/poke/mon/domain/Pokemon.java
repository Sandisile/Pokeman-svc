
package org.poke.mon.domain;

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
public class Pokemon {

    private Integer height;
    private Long id;
    @JsonProperty(value="is_default")
    private Boolean isDefault;
    @JsonProperty(value="sprites")
    private Sprite sprite;
}
