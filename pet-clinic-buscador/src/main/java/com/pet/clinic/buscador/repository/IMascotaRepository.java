package com.pet.clinic.buscador.repository;

import com.pet.clinic.buscador.models.entity.Mascota;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMascotaRepository extends CrudRepository<Mascota, Long> {
}
