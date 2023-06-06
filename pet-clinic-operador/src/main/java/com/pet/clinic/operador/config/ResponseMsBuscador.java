package com.pet.clinic.operador.config;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pet.clinic.operador.config.ResponseMsBuscador;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Scope("Prototype")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseMsBuscador implements Serializable  {
	 	private String messages;
	    private Object data;
}
