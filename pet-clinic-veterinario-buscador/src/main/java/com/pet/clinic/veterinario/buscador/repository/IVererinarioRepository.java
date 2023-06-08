package com.pet.clinic.veterinario.buscador.repository;



import com.pet.clinic.veterinario.buscador.models.dto.BuscarTodosLab;
import com.pet.clinic.veterinario.buscador.models.dto.VeterinarioDto;
import com.pet.clinic.veterinario.buscador.models.entity.Veterinario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface IVererinarioRepository extends CrudRepository<Veterinario, Long> {

    @Query(value = " SELECT p.primer_nombrevet AS primerNombrevet, p.segundo_nombrevet AS segundoNombrevet, " +
            "p.primer_apellidovet AS primerApellidovet, " +
            " p.segundo_apellidovet AS segundoApellidovet, e.codigoEspecialidad AS codigoEspecialidad, e.tipoEspecialidad AS tipoEspecialidad" +
            " FROM veterinario p INNER JOIN especialidades e ON p.especialidades_id = e.especialidades_id " +
            " WHERE p.primer_nombrevet LIKE %:buscar% "+
            " OR p.segundo_nombrevet LIKE %:buscar% "+
            " OR p.primer_apellidovet LIKE %:buscar% "+
            " OR p.segundo_apellidovet LIKE %:buscar% "+
            " OR e.codigoEspecialidad LIKE %:buscar% "+
            " OR e.tipoEspecialidad LIKE %:buscar% order by p.primer_nombre ASC ", nativeQuery = true)
    List<BuscarTodosLab> listBuscarTodoVet (@Param("buscar") String buscar);

}
