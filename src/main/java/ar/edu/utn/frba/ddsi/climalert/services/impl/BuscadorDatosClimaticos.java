package ar.edu.utn.frba.ddsi.climalert.services.impl;

import ar.edu.utn.frba.ddsi.climalert.config.WeatherApiProperties;
import ar.edu.utn.frba.ddsi.climalert.dtos.external.weatherApi.ClimaData;
import ar.edu.utn.frba.ddsi.climalert.entities.DatosClimaticos;
import ar.edu.utn.frba.ddsi.climalert.repositories.ClimaDataRepository;
import ar.edu.utn.frba.ddsi.climalert.services.BuscadorDatosClimaticosService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class BuscadorDatosClimaticos implements BuscadorDatosClimaticosService {
    private WeatherApiProperties weatherProperties;
    private RestTemplate restTemplate;
    private ClimaDataRepository climaDataRepository;

    public BuscadorDatosClimaticos(WeatherApiProperties weatherProperties, RestTemplate restTemplate, ClimaDataRepository climaDataRepository) {
        this.weatherProperties = weatherProperties;
        this.restTemplate = restTemplate;
        this.climaDataRepository = climaDataRepository;
    }

    @Override
    public void actualizarDatosClima() {
        ClimaData climaDataActual = buscarDatosClima();
        if(climaDataActual == null) return;

        DatosClimaticos datosClimaticos = mapClimaDataToDatosClimaticos(climaDataActual);
        System.out.println("[BuscadorDatosClimaticos] Datos obtenidos: " + datosClimaticos);
        climaDataRepository.save(datosClimaticos);
    }

    private DatosClimaticos mapClimaDataToDatosClimaticos(ClimaData climaDataActual) {
        return new DatosClimaticos(
                null,
                climaDataActual.getCurrent().getLastUpdated(),
                climaDataActual.getCurrent().getTempC(),
                climaDataActual.getCurrent().getHumidity(),
                climaDataActual.getCurrent().getWindKph(),
                climaDataActual.getCurrent().getChanceOfRain(),
                climaDataActual.getLocation().getCountry(),
                climaDataActual.getLocation().getRegion(),
                climaDataActual.getLocation().getName(),
                false);
    }

    private ClimaData buscarDatosClima() {
        System.out.println("[BuscadorDatosClimaticos] Buscando datos...");
        URI uri = UriComponentsBuilder
                .fromUriString(weatherProperties.getBaseUrl())
                .path("/current.json")
                .queryParam("key", weatherProperties.getApiKey())
                .queryParam("q", "Ciudad Autonoma de Buenos Aires")
                .build()
                .toUri();

        return restTemplate.getForObject(uri, ClimaData.class);
    }
}
