package ar.edu.utn.frba.ddsi.climalert.dtos.external.weatherApi;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrentData {

    @JsonProperty("last_updated")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime lastUpdated;

    @JsonProperty("temp_c")
    private float tempC;

    @JsonProperty("wind_kph")
    private float windKph;

    @JsonProperty("humidity")
    private float humidity;

    @JsonProperty("chance_of_rain")
    private float chanceOfRain;
}
