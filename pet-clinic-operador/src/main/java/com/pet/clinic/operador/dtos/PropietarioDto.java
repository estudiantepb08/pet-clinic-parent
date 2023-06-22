package com.pet.clinic.operador.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropietarioDto {

    
    private String propietariosId;
    
    private String primerNombre;
    private String segundoNombre;
    
    private String primerApellido;
    
    private String segundoApellido;
    
    private String telefono;
    private String direccion;
    
    private String correoElectronico;
}