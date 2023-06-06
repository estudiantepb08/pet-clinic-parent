package com.pet.clinic.operador.facade;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.pet.clinic.operador.config.ResponseMsBuscador;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

import lombok.RequiredArgsConstructor;
@Component
@RequiredArgsConstructor
public class OwnerFacade {

	   private final RestTemplate restTemplate;

	    @Value("${owner.url}")
	    private String ownerUrl;

	    public ResponseMsBuscador getOwner(String id) {
	        HttpHeaders headers = new HttpHeaders();
	        HttpEntity<?> requestEntity = new HttpEntity<>(headers);

	        ResponseEntity<ResponseMsBuscador> response = restTemplate.exchange(
	        		ownerUrl + "?mascotaId={mascotaId}", HttpMethod.GET, requestEntity,
	                ResponseMsBuscador.class, id);

	        ResponseMsBuscador responseMsBuscador = response.getBody();
	        
	        return responseMsBuscador;
	    }
}
