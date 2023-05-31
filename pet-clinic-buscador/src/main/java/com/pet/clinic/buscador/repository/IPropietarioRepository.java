package com.pet.clinic.buscador.repository;

import com.pet.clinic.buscador.models.dtos.PropietarioDto;
import com.pet.clinic.buscador.models.entity.Propietario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPropietarioRepository extends CrudRepository<Propietario, Long> {

    @Query(value = " SELECT new com.pet.clinic.buscador.models.dtos.PropietarioDto(p.propietariosId, " +
            " p.primerNombre, p.segundoNombre, p.primerApellido, p.segundoApellido, c.telefono, c.direccion, c.correoElectronico) " +
            " FROM Propietario p INNER JOIN p.contactoId c ")
    List<PropietarioDto> getPropietarioContacto();

    @Query(value = " SELECT new com.pet.clinic.buscador.models.dtos.PropietarioDto(p.propietariosId, " +
            " p.primerNombre, p.segundoNombre, p.primerApellido, p.segundoApellido, c.telefono, c.direccion, c.correoElectronico) " +
            " FROM Propietario p INNER JOIN p.contactoId c WHERE p.propietariosId =:idPropietario ")
    List<PropietarioDto> getPropietarioPorIdContacto(@Param("idPropietario") Long idPropietario);
}
