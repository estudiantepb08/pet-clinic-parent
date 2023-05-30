package com.pet.clinic.buscador.repository;

import com.pet.clinic.buscador.models.dtos.IPropietarioDto;
import com.pet.clinic.buscador.models.entity.Propietario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPropietarioRepository extends CrudRepository<Propietario, Long> {

    @Query(value = " SELECT new com.pet.clinic.buscador.models.dtos.IPropietarioDto(p.propietariosId, " +
            " p.primerNombre, p.segundoNombre, p.primerApellido, p.segundoApellido, c.telefono, c.direccion, c.correoElectronico) " +
            " FROM Propietario p INNER JOIN p.contactoId c ")
    List<IPropietarioDto> getPropietarioContacto();

    @Query(value = " SELECT new com.pet.clinic.buscador.models.dtos.IPropietarioDto(p.propietariosId, " +
            " p.primerNombre, p.segundoNombre, p.primerApellido, p.segundoApellido, c.telefono, c.direccion, c.correoElectronico) " +
            " FROM Propietario p INNER JOIN p.contactoId c WHERE p.propietariosId =: idPropietario ")
    List<IPropietarioDto> getPropietarioPorIdContacto(@Param("idPropietario") Long idPropietario);
}
