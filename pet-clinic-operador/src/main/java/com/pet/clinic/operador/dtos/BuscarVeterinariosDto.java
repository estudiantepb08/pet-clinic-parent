package com.pet.clinic.operador.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BuscarVeterinariosDto {
    	String veterinarioId;
	 	String primerNombrevet;
	    String segundoNombrevet;
	    String primerApellidovet;
	    String segundoApellidovet;
	
}
