package com.pet.clinic.veterinario.buscador.repository;

import java.util.*;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.pet.clinic.veterinario.buscador.models.entity.VeterinarioElastic;

public interface IVeterinarioRepositoryElastic extends ElasticsearchRepository<VeterinarioElastic, String>{
	List<VeterinarioElastic> findByprimerNombreVet(String primerNombreVet);
	
	Optional<VeterinarioElastic> findById(String id);
	
	VeterinarioElastic save(VeterinarioElastic veterinario);
	
	void delete(VeterinarioElastic veterinario);
	
	List<VeterinarioElastic> findAll();
    @Query("{\"bool\": {\"must\": [{\"multi_match\": {\"query\": \"?0\",\"fields\": [\"primerNombreVet\", \"segundoNombreVet\", \"primerApellidoVet\", \"segundoApellidoVet\"]}}]}}")
	List<VeterinarioElastic> findByTerms(String searchTerm);
}
