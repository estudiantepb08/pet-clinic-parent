package com.pet.clinic.buscador.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.pet.clinic.buscador.models.entity.MascotaElastic;

public interface IMascotaRepositoryElastic extends ElasticsearchRepository<MascotaElastic, String> {

	Optional<MascotaElastic> findById(String id);
	
	MascotaElastic save(MascotaElastic mascota);
	
	void delete(MascotaElastic mascota);
	
	List<MascotaElastic> findAll();

}
