package com.pet.clinic.buscador.repository;

import com.pet.clinic.buscador.models.entity.Propietario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPropietarioRepository extends CrudRepository<Propietario, Long> {
}
