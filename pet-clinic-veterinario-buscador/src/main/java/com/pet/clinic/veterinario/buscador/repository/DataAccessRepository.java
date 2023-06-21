package com.pet.clinic.veterinario.buscador.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.data.elasticsearch.core.SearchHits;
import com.pet.clinic.veterinario.buscador.models.entity.VeterinarioElastic;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class DataAccessRepository {
	private final IVeterinarioRepositoryElastic veterinarioRepository;
	private final ElasticsearchOperations elasticClient;
	
	
	public VeterinarioElastic save(VeterinarioElastic veterinario) {
		return veterinarioRepository.save(veterinario);
		
	}
	
	public Boolean deleteById(VeterinarioElastic veterinario) {
		veterinarioRepository.delete(veterinario);
		return Boolean.TRUE;
	}
	
	public Optional<VeterinarioElastic> findById(String id){
		return veterinarioRepository.findById(id);
	}
	
	public List<VeterinarioElastic> findAll(){
		return veterinarioRepository.findAll();
	}
	public List<VeterinarioElastic> listBuscarTodoVet(String buscar){
		 MultiMatchQueryBuilder query = QueryBuilders.multiMatchQuery(buscar)
		            .field("primerNombreVet", 0.5f)
		            .field("segundoNombreVet", 0.5f)
		            .field("primerApellidoVet", 0.5f)
		            .field("segundoApellidoVet", 0.5f)
		            .type(MultiMatchQueryBuilder.Type.PHRASE_PREFIX);
	    NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
	            .withQuery(query)
	            .build();

	    SearchHits<VeterinarioElastic> resultados = elasticClient.search(searchQuery, VeterinarioElastic.class);

	    return resultados.getSearchHits().stream().map(SearchHit::getContent).toList();
	//	return veterinarioRepository.findByTerms(buscar);
	}
}
