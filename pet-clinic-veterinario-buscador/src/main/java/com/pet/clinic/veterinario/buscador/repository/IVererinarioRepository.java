package com.pet.clinic.veterinario.buscador.repository;



import com.pet.clinic.veterinario.buscador.models.dto.BuscarTodosLab;
import com.pet.clinic.veterinario.buscador.models.dto.VeterinarioDto;
import com.pet.clinic.veterinario.buscador.models.entity.Veterinario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface IVererinarioRepository extends JpaRepository<Veterinario, Long> {

    @Query(value = " SELECT p.veterinario_id AS veterinarioId, p.primer_nombrevet AS primerNombreVet, p.segundo_nombrevet AS segundoNombreVet, " +
            "p.primer_apellidovet AS primerApellidoVet, " +
            " p.segundo_apellidovet AS segundoApellidoVet, e.codigo_especialidad AS codigoEspecialidad, e.tipo_especialidad AS tipoEspecialidad" +
            " FROM veterinario p INNER JOIN especialidades e ON p.especialidades_id = e.especialidades_id " +
            " WHERE p.primer_nombrevet LIKE %:buscar% "+
            " OR p.segundo_nombrevet LIKE %:buscar% "+
            " OR p.primer_apellidovet LIKE %:buscar% "+
            " OR p.segundo_apellidovet LIKE %:buscar% "+
            " OR CAST(e.codigo_especialidad AS varchar) LIKE %:buscar% "+
            " OR e.tipo_especialidad LIKE %:buscar% order by p.primer_nombrevet ASC ", nativeQuery = true)
    List<BuscarTodosLab> listBuscarTodoVet (@Param("buscar") String buscar);

}
