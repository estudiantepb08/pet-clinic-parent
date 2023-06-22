package com.pet.clinic.buscador.repository;

import java.util.*;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.pet.clinic.buscador.models.entity.TipoMascotaElastic;

public interface ITipoMascotaElasticRepository extends ElasticsearchRepository<TipoMascotaElastic, String> {

	List<TipoMascotaElastic> findAll();
	Optional<TipoMascotaElastic> findById(String id);
}
