package com.pet.clinic.operador.dtos;

import java.time.LocalDateTime;

public class VisitDto {

private Long idVisit;
	
	private LocalDateTime dateVisit;
	
	private Long idPet;
	
	private Long idOwner;
	
	private Long idVeterinary;
	
	private String reason;
	
	private Double cost;
	
	private boolean isFirstVisit;
}
