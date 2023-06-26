package com.pet.clinic.operador.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BuscarTodoDtoResponse {
	Long ownerId;
	Long petId;
	String primerNombre;
    String segundoNombre;
    String primerApellido;
    String segundoApellido;
    String telefono;
    String direccion;
    String correoElectronico;
    String nombreMascota;
    String fechaNacimiento;
    String tipoMascoTa;
}
