package com.pet.clinic.buscador.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Repository;

import com.pet.clinic.buscador.models.entity.MascotaElastic;
import com.pet.clinic.buscador.models.entity.TipoMascotaElastic;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class DataAccessRepositoryTypePets {
	private final ITipoMascotaElasticRepository iTipoMascotaRepository;
	private final ElasticsearchOperations elasticClient;
	
	public List<TipoMascotaElastic> findAll(){
		return iTipoMascotaRepository.findAll();
	}
	public Optional<TipoMascotaElastic> findById(String id){
		return iTipoMascotaRepository.findById(id);
	}
}
