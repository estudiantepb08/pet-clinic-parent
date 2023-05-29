package com.pet.clinic.buscador.repository;

import com.pet.clinic.buscador.models.entity.TipoMascota;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoMascotaRepository extends CrudRepository<TipoMascota, Long> {
}
