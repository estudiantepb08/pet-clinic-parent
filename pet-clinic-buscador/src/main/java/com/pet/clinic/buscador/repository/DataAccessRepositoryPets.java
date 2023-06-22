package com.pet.clinic.buscador.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Repository;

import com.pet.clinic.buscador.models.entity.MascotaElastic;

import org.springframework.data.elasticsearch.core.SearchHits;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class DataAccessRepositoryPets {
	private final IMascotaRepositoryElastic mascotaRepository;
	private final ElasticsearchOperations elasticClient;
	
	
	public MascotaElastic save(MascotaElastic mascota) {
		return mascotaRepository.save(mascota);
		
	}
	
	public Boolean deleteById(MascotaElastic mascota) {
		mascotaRepository.delete(mascota);
		return Boolean.TRUE;
	}
	
	public Optional<MascotaElastic> findById(String id){
		return mascotaRepository.findById(id);
	}
	
	public List<MascotaElastic> findAll(){
		return mascotaRepository.findAll();
	}
	public List<MascotaElastic> listBuscarTodo(String buscar) {
	    QueryBuilder query = QueryBuilders.boolQuery()
	            .should(QueryBuilders.multiMatchQuery(buscar)
	            		.field("nombreMascota", 0.5f)
	            	    .field("propietario.segundoApellido", 0.5f)
			            .field("propietario.segundoNombre", 0.5f)
			            .field("propietario.primerNombre", 0.5f)
			            .field("propietario.primerApellido", 0.5f)
			            .field("tipoMascota.tipoMascota.keyword", 0.5f)
			            .type(MultiMatchQueryBuilder.Type.PHRASE_PREFIX))
	            .should(QueryBuilders.termQuery("tipoMascota.tipoMascota", buscar));

	    NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
	            .withQuery(query)
	            .build();

	    SearchHits<MascotaElastic> resultados = elasticClient.search(searchQuery, MascotaElastic.class);

	    return resultados.getSearchHits().stream()
	            .map(SearchHit::getContent)
	            .toList();
	}
}
