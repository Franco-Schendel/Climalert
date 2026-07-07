package ar.edu.utn.frba.ddsi.climalert.scheduler;

import ar.edu.utn.frba.ddsi.climalert.services.BuscadorDatosClimaticosService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ClimaScheduler {
    private static final Logger logger = LoggerFactory.getLogger(ClimaScheduler.class);
    private final BuscadorDatosClimaticosService climaService;

    public ClimaScheduler(BuscadorDatosClimaticosService climaService) {
        this.climaService = climaService;
    }

    @Scheduled(fixedRate = 300000) // 300000 ms = 5 minutos
    public void actualizarClima() {
        climaService.actualizarDatosClima();
    }
}