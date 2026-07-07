package ar.edu.utn.frba.ddsi.climalert.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Alerta {
    private Long id;
    private DatosClimaticos datosClima;
    private String mensaje;
    private List<String> emailsDestinatarios;
}
