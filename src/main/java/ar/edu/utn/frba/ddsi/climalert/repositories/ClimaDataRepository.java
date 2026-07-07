package ar.edu.utn.frba.ddsi.climalert.repositories;

import ar.edu.utn.frba.ddsi.climalert.entities.DatosClimaticos;

import java.util.List;
import java.util.Optional;

public interface ClimaDataRepository {

    public List<DatosClimaticos> findAll();

    public Optional<DatosClimaticos> findById(long id);

    public DatosClimaticos save(DatosClimaticos datosClimaticos);

    public List<DatosClimaticos> findByProcesado(boolean procesado);

    public void delete(long id);

}
