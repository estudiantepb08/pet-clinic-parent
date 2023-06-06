package com.pet.clinic.operador.dtos;

import java.time.LocalDateTime;

import com.pet.clinic.operador.enums.StatusVisit;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class VisitDto {

	private Long idVisit;
	
	private LocalDateTime dateVisit;
	
	private Long idPet;
	
	private Long idOwner;
	
	private Long idVeterinary;
	
	private String reason;
	
	private Double cost;
	
	private Boolean isFirstVisit;
	
	private StatusVisit status;

}
