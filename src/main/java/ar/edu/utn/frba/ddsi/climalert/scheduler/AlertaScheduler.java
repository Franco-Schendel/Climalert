package ar.edu.utn.frba.ddsi.climalert.scheduler;

import ar.edu.utn.frba.ddsi.climalert.services.AlertasService;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class AlertaScheduler {
    private final AlertasService alertasService;

    public AlertaScheduler(AlertasService alertasService) {
        this.alertasService = alertasService;
    }

    @Scheduled(fixedRate = 60000) // Cada 1 minuto
    public void procesarAlertas() {
        alertasService.generarAlertasYAvisar();
    }
}