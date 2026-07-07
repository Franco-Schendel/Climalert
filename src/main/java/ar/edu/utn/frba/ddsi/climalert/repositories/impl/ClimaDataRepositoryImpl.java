package ar.edu.utn.frba.ddsi.climalert.repositories.impl;

import ar.edu.utn.frba.ddsi.climalert.entities.DatosClimaticos;
import ar.edu.utn.frba.ddsi.climalert.repositories.ClimaDataRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ClimaDataRepositoryImpl implements ClimaDataRepository {

    private final List<DatosClimaticos> datosClimaticosList = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public List<DatosClimaticos> findAll() {
        return datosClimaticosList;
    }

    @Override
    public Optional<DatosClimaticos> findById(long id) {
        return datosClimaticosList.stream().filter(datosClimaticos -> datosClimaticos.getId() == id).findFirst();
    }

    @Override
    public DatosClimaticos save(DatosClimaticos datosClimaticos) {
        if (datosClimaticos.getId() == null) {
            Long id = idGenerator.getAndIncrement();
            datosClimaticos.setId(id);
            datosClimaticosList.add(datosClimaticos);
        } else {
            delete(datosClimaticos.getId());
            datosClimaticosList.add(datosClimaticos);
        }
        return datosClimaticos;
    }

    @Override
    public List<DatosClimaticos> findByProcesado(boolean procesado){
        return datosClimaticosList.stream().filter(datosClimaticos -> datosClimaticos.getProcesado() == procesado).toList();
    }

    @Override
    public void delete(long id) {
        datosClimaticosList.removeIf(datos -> datos.getId().equals(id));
    }
}
