package com.pet.clinic.buscador.models.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PropietarioDto {

    @NotBlank
    private Long propietariosId;
    @NotBlank
    @Size(min = 3, max = 20)
    private String primerNombre;
    @NotBlank
    @Size(min = 3, max = 20)
    private String segundoNombre;
    @NotBlank
    @Size(min = 3, max = 20)
    private String primerApellido;
    @NotBlank
    @Size(min = 3, max = 20)
    private String segundoApellido;
    @NotBlank
    @Size(min = 3, max = 20)
    private String telefono;
    @NotBlank
    @Size(min = 3, max = 20)
    private String direccion;
    @NotBlank
    @Size(min = 3, max = 20)
    private String correoElectronico;
}