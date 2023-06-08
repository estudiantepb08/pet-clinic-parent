package com.pet.clinic.veterinario.buscador.repository;

import com.pet.clinic.veterinario.buscador.models.dto.EspecialidadDto;
import com.pet.clinic.veterinario.buscador.models.entity.Especialidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEspecialidadRepository extends JpaRepository<Especialidad, Long> {

}
