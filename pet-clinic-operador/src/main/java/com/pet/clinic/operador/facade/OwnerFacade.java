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

	    public ResponseMsBuscador getOwner(String propietarioId) {
	        HttpHeaders headers = new HttpHeaders();
	        HttpEntity<?> requestEntity = new HttpEntity<>(headers);

	        ResponseEntity<ResponseMsBuscador> response = restTemplate.exchange(
	        		ownerUrl + "/propietarios/" + propietarioId, HttpMethod.GET, requestEntity,
	                ResponseMsBuscador.class, propietarioId);
	        System.out.println(response);
			System.out.println(response + " Response" + response.getStatusCode() + response.toString());

	        ResponseMsBuscador responseMsBuscador = response.getBody();
	        System.out.println(responseMsBuscador);

	        return responseMsBuscador;
	    }
}
