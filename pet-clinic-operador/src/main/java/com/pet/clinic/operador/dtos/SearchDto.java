package com.pet.clinic.operador.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class SearchDto {

	private String paramMSBuscador;
	
	private String paramMSVeterinary;
	
	private String veterinary;
	
	private String status;
	
	private String cost;
	
	private String isFirstVisit;
	
	private String reason;
	
	private String dateVisit;
	
	
}
