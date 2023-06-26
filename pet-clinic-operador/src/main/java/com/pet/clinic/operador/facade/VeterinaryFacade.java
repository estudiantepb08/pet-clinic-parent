package com.pet.clinic.operador.facade;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.pet.clinic.operador.config.ResponseMsBuscador;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class VeterinaryFacade {
	   private final RestTemplate restTemplate;

	   @Value("${veterinary.url}")
	    private String veterinaryUrl;
	    public ResponseMsBuscador getVeterinary(String veterinarioId) {
	        HttpHeaders headers = new HttpHeaders();
	        HttpEntity<?> requestEntity = new HttpEntity<>(headers);

	        ResponseEntity<ResponseMsBuscador> response = restTemplate.exchange(
	        		veterinaryUrl + "/veterinario" + "/{veterinarioId}", HttpMethod.GET, requestEntity,
	                ResponseMsBuscador.class, veterinarioId);
	        System.out.println(response);
			System.out.println(response + " Response" + response.getStatusCode() + response.toString());

	        ResponseMsBuscador responseMsBuscador = response.getBody();
	        System.out.println(responseMsBuscador);

	        return responseMsBuscador;
	    }
	    
	    public ResponseMsBuscador searchTodo(String paramSearch) {
	    	HttpHeaders headers = new HttpHeaders();
	    	HttpEntity<?> requestEntity = new HttpEntity<>(headers);
	    	ResponseEntity<ResponseMsBuscador> response = restTemplate.exchange(
	    			veterinaryUrl + "/veterinario" + "/todos" + "?buscar={paramSearch}",HttpMethod.GET, requestEntity,
	    			ResponseMsBuscador.class, paramSearch);
			System.out.println(response + " Response" + response.getStatusCode() + response.toString());

	    	ResponseMsBuscador responseMsBuscador = response.getBody();
	    	
	    	return responseMsBuscador;
	    }
}
