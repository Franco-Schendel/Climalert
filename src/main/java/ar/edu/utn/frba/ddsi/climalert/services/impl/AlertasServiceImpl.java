package ar.edu.utn.frba.ddsi.climalert.services.impl;

import ar.edu.utn.frba.ddsi.climalert.entities.Alerta;
import ar.edu.utn.frba.ddsi.climalert.entities.DatosClimaticos;
import ar.edu.utn.frba.ddsi.climalert.repositories.ClimaDataRepository;
import ar.edu.utn.frba.ddsi.climalert.services.AlertasService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertasServiceImpl implements AlertasService {
    private ClimaDataRepository climaDataRepository;
    private final List<String> emailsDestinatarios = List.of("admin@clima.com", "emergencias@clima.com", "meteorologia@clima.com");

    public AlertasServiceImpl(ClimaDataRepository climaDataRepository) {
        this.climaDataRepository = climaDataRepository;
    }

    @Override
    public void generarAlertasYAvisar() {
        List<DatosClimaticos> datosClimaticosNoProcesados = climaDataRepository.findByProcesado(false);
        datosClimaticosNoProcesados.forEach(datosClimaticos -> {
            if(!datosClimaticos.esCritico()) return;
            Alerta nuevaAlerta = new Alerta(null,
                    datosClimaticos,
            "ALERTA\n" +
                        "ID: " + datosClimaticos.getId() + "\n" +
                        "La temperatura actual es de " + datosClimaticos.getTemperatura() + "°C. Y la humedad es del " + datosClimaticos.getHumedad() + " %\n" +
                        "Pais: " + datosClimaticos.getPais() + "\n" +
                        "Region: " + datosClimaticos.getRegion() + "\n" +
                        "Ciudad: " + datosClimaticos.getCiudad() + "\n",
                    emailsDestinatarios);
            System.out.println("Enviando alerta a destinatarios por datos " + datosClimaticos.getId());
        });
    }
}
