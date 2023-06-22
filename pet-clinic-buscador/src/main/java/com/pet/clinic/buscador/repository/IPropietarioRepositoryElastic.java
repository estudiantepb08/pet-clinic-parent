package com.pet.clinic.buscador.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.pet.clinic.buscador.models.entity.PropietarioElastic;


public interface IPropietarioRepositoryElastic extends ElasticsearchRepository<PropietarioElastic, String>{

	
	Optional<PropietarioElastic> findById(String id);
	
	PropietarioElastic save(PropietarioElastic propietario);
	
	void delete(PropietarioElastic propietario);
	
	List<PropietarioElastic> findAll();
}
