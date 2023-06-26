package com.pet.clinic.buscador.repository;

import com.pet.clinic.buscador.models.dtos.BuscarTodoDto;
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
            " FROM Mascota ma INNER JOIN ma.tipoMascota tm ")
    List<MascotaDto> getMascotasAntTipo();

    @Query(value = " SELECT new com.pet.clinic.buscador.models.dtos.MascotaDto(ma.mascotasId, ma.nombreMascota, ma.fechaNacimiento, tm.tipoMascota) " +
            " FROM Mascota ma INNER JOIN ma.tipoMascota tm WHERE ma.mascotasId =:idMascota ")
    List<MascotaDto> getMascotaPorIdAntTipo(@Param("idMascota") Long idMascota);

    @Query(value = " SELECT p.propietarios_id AS propietariosId, p.primer_nombre AS primerNombre, p.segundo_nombre AS segundoNombre, p.primer_apellido AS primerApellido, " +
            " p.segundo_apellido AS segundoApellido, c.telefono AS telefono, c.direccion AS direccion, c.correo_electronico AS correoElectronico, " +
            " m.nombre_mascota AS nombreMascota, m.fecha_nacimiento AS fechaNacimiento, tm.tipo_mascota AS tipoMascota, m.mascotas_id AS mascotasId"  +
            " FROM propietarios p INNER JOIN contactos c ON p.propietarios_id = c.propietarios_id "+
            " INNER JOIN mascotas m ON p.propietarios_id = m.propietarios_id " +
            " INNER JOIN tipo_mascotas tm ON m.tipo_mascotas_id = tm.tipo_mascotas_id " +
            " WHERE p.primer_nombre LIKE %:buscar% "+
            " OR p.segundo_nombre LIKE %:buscar% "+
            " OR p.primer_apellido LIKE %:buscar% "+
            " OR p.segundo_apellido LIKE %:buscar% "+
            " OR c.telefono LIKE %:buscar% "+
            " OR c.direccion LIKE %:buscar% "+
            " OR c.correo_electronico LIKE %:buscar% "+
            " OR m.nombre_mascota LIKE %:buscar% "+
            " OR CAST(m.fecha_nacimiento AS varchar) LIKE %:buscar% "+
            " OR tm.tipo_mascota LIKE %:buscar% order by p.primer_nombre ASC ", nativeQuery = true)
    List<BuscarTodoDto> listBuscarTodo(@Param("buscar") String buscar);
}
