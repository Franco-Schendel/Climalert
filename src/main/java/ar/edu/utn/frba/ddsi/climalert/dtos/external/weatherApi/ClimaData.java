package ar.edu.utn.frba.ddsi.climalert.dtos.external.weatherApi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClimaData {

    @JsonProperty("location")
    private LocationData location;

    @JsonProperty("current")
    private CurrentData current;

}
