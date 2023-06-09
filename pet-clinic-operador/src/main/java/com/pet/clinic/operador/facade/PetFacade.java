package com.pet.clinic.operador.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.pet.clinic.operador.config.ResponseMsBuscador;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PetFacade {

	   @Autowired
	   private final RestTemplate restTemplate;
	   

	    @Value("${pet.url}")
	    private String petUrl;
	    
	    public ResponseMsBuscador getPet(Long mascotaId) {
	        HttpHeaders headers = new HttpHeaders();
	        HttpEntity<?> requestEntity = new HttpEntity<>(headers);

	        ResponseEntity<ResponseMsBuscador> response = restTemplate.exchange(
	        		petUrl + "/mascotas" + "?mascotaId={mascotaId}", HttpMethod.GET, requestEntity,
	                ResponseMsBuscador.class, mascotaId);

	        ResponseMsBuscador responseMsBuscador = response.getBody();
	        
	        return responseMsBuscador;
	    }
	    
	    public ResponseMsBuscador searchTodo(String paramSearch) {
	    	HttpHeaders headers = new HttpHeaders();
	    	HttpEntity<?> requestEntity = new HttpEntity<>(headers);
	    	ResponseEntity<ResponseMsBuscador> response = restTemplate.exchange(
	    			petUrl + "/mascotas" + "/buscar-todo" + "?buscar={paramSearch}",HttpMethod.GET, requestEntity,
	    			ResponseMsBuscador.class, paramSearch);
	    	
	    	ResponseMsBuscador responseMsBuscador = response.getBody();
	    	
	    	return responseMsBuscador;
	    }

}
