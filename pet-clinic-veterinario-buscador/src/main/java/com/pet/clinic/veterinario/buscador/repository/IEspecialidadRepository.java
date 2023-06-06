package com.pet.clinic.veterinario.buscador.repository;

import com.pet.clinic.veterinario.buscador.models.dto.EspecialidadDto;
import com.pet.clinic.veterinario.buscador.models.entity.Especialidades;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface IEspecialidadRepository extends CrudRepository <Especialidades, Long>{

    @Query(value = "SELECT new com.pet.clinic.veterinario.buscador.models.dtos.EspecialidadDto(ma.especialidadId, ma.especialidad)" 
    + " FROM Especilidad ma")
    List<EspecialidadDto> getEspecialidad();

    @Query(value = "SELECT new com.pet.clinic.veterinario.buscador.models.dtos.EspecialidadDto(ma.especialidadId, ma.especialidad)"
     + " FROM Especilidad ma WHERE ma.especialidadId =: ma.especialidadId")
    List<EspecialidadDto> getEspecialidad(@Param("idEspecialidad")Long idEspecialidad);
    
}
