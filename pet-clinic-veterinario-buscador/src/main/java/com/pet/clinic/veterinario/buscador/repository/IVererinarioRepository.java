package com.pet.clinic.veterinario.buscador.repository;



import com.pet.clinic.veterinario.buscador.models.dto.VeterinarioDto;
import com.pet.clinic.veterinario.buscador.models.entity.Veterinario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface IVererinarioRepository extends CrudRepository<Veterinario, Long> {

    @Query (value =  " SELECT new com.pet.clinic.buscador.models.dtos.PropietarioDto(p.veterinarioId, " +
    " p.primerNombreVet, p.segundoNombreVet, p.primerApellidoVet, p.segundoApellidoVet) " +
    " FROM Veterinario p")
    List<VeterinarioDto> getVeterinario();

    @Query (value =  " SELECT new com.pet.clinic.buscador.models.dtos.PropietarioDto(p.veterinarioId, " +
    " p.primerNombreVet, p.segundoNombreVet, p.primerApellidoVet, p.segundoApellidoVet) " +
    " FROM Veterinario p WHERE p.veterinarioId =:idVeterinario")
    List<VeterinarioDto> getVeterinario(@Param("idVeterinario")Long idVeterinario);
}
