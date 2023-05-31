package com.pet.clinic.buscador.repository;

import com.pet.clinic.buscador.models.dtos.MascotaDto;
import com.pet.clinic.buscador.models.entity.Mascota;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMascotaRepository extends CrudRepository<Mascota, Long> {

    @Query(value = " SELECT new com.pet.clinic.buscador.models.dtos.MascotaDto(ma.mascotasId, ma.nombreMascota, ma.fechaNacimiento, tm.tipoMascota) " +
            " FROM Mascota ma INNER JOIN ma.tipoMascotasId tm ")
    List<MascotaDto> getMascotasAntTipo();

    @Query(value = " SELECT new com.pet.clinic.buscador.models.dtos.MascotaDto(ma.mascotasId, ma.nombreMascota, ma.fechaNacimiento, tm.tipoMascota) " +
            " FROM Mascota ma INNER JOIN ma.tipoMascotasId tm WHERE ma.mascotasId =:idMascota ")
    List<MascotaDto> getMascotaPorIdAntTipo(@Param("idMascota") Long idMascota);
}
