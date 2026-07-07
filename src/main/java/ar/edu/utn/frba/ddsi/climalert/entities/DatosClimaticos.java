package ar.edu.utn.frba.ddsi.climalert.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class DatosClimaticos {
    private Long id;
    private LocalDateTime fecha;
    private float temperatura;
    private float humedad;
    private float vientoKph;
    private float probabilidadLluvia;
    private String pais;
    private String region;
    private String ciudad;
    private boolean procesado;

    public boolean esCritico() {
        return temperaturaCritica() || humedadCritica();
    }

    private boolean humedadCritica() {
        return this.humedad > 60f;
    }

    private boolean temperaturaCritica() {
        return this.temperatura > 35f;
    }

    public boolean getProcesado() {
        return procesado;
    }
}
