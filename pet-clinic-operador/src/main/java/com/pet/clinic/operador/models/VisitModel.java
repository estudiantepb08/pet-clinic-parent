package com.pet.clinic.operador.models;

import java.time.LocalDateTime;

import com.pet.clinic.operador.enums.StatusVisit;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name="Visit")
@Entity
public class VisitModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long idVisit;
	
	@Column(nullable = false)	
	private LocalDateTime dateVisit;
	
	@Column(nullable = false)	
	private String idPet;
	
	@Column(nullable = false)	
	private String idOwner;
	
	@Column(nullable = false)	
	private String idVeterinary;
	
	@Column(nullable = false)	
	private String reason;
	
	@Column(nullable = false)	
	private Double cost;
	
	@Column(nullable = false)	
	private boolean isFirstVisit;
	
	@Enumerated(value = EnumType.STRING)
	@Column(nullable = false)	
	private StatusVisit status;
}
