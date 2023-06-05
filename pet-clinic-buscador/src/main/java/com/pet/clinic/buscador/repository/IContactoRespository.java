package com.pet.clinic.buscador.repository;

import com.pet.clinic.buscador.models.entity.Contacto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContactoRespository extends CrudRepository<Contacto,Long> {

}
