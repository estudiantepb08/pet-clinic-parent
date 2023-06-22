package com.pet.clinic.buscador.repository;

import java.util.List;
import java.util.Optional;

import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Repository;

import com.pet.clinic.buscador.models.entity.PropietarioElastic;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class DataAccessRepositoryOwners {

	private final IPropietarioRepositoryElastic propietarioRepository;
	private final ElasticsearchOperations elasticClient;
	
	
	public PropietarioElastic save(PropietarioElastic propietario) {
		return propietarioRepository.save(propietario);
		
	}
	
	public Boolean deleteById(PropietarioElastic propietario) {
		propietarioRepository.delete(propietario);
		return Boolean.TRUE;
	}
	
	public Optional<PropietarioElastic> findById(String id){
		return propietarioRepository.findById(id);
	}
	
	public List<PropietarioElastic> findAll(){
		return propietarioRepository.findAll();
	}
	public List<PropietarioElastic> listBuscarTodoVet(String buscar){
		 MultiMatchQueryBuilder query = QueryBuilders.multiMatchQuery(buscar)
		            .field("primerNombre", 0.5f)
		            .field("segundoNombre", 0.5f)
		            .field("primerApellido", 0.5f)
		            .field("segundoApellido", 0.5f)
		            .type(MultiMatchQueryBuilder.Type.PHRASE_PREFIX);
	    NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
	            .withQuery(query)
	            .build();

	    SearchHits<PropietarioElastic> resultados = elasticClient.search(searchQuery, PropietarioElastic.class);

	    return resultados.getSearchHits().stream().map(SearchHit::getContent).toList();
	//	return veterinarioRepository.findByTerms(buscar);
	}
}
