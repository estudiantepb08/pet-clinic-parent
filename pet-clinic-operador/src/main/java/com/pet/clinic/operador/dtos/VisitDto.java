package com.pet.clinic.operador.dtos;

import java.time.LocalDateTime;

import com.pet.clinic.operador.enums.StatusVisit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class VisitDto {

	private Long idVisit;
	
	private LocalDateTime dateVisit;
	
	private MascotaDto pet;
	
	private PropietarioDto owner;
	
	private Long idVeterinary;
	
	private String reason;
	
	private Double cost;
	
	private Boolean isFirstVisit;
	
	private StatusVisit status;

}
