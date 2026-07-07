package ar.edu.utn.frba.ddsi.climalert;

import ar.edu.utn.frba.ddsi.climalert.dtos.external.weatherApi.ClimaData;
import ar.edu.utn.frba.ddsi.climalert.services.impl.BuscadorDatosClimaticos;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class BuscadorDatosClimaticosTests {

    @Autowired
    private BuscadorDatosClimaticos buscadorDatosClimaticos;


    @Test
    void buscarDatosClimaDevuelveDatosClimaticos() {
        ClimaData climaData = buscadorDatosClimaticos.buscarDatosClima();
        System.out.println(climaData);

        assertThat(climaData).isNotNull();
    }
}
