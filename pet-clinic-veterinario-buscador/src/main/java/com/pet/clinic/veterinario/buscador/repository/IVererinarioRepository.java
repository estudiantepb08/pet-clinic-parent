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
}
