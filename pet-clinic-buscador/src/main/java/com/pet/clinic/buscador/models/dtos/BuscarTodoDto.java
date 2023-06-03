package com.pet.clinic.buscador.models.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;

@Builder
@Getter
@Setter

public class BuscarTodoDto extends PropietarioDto {

    public BuscarTodoDto(@NotBlank Long propietariosId, @NotBlank @Size(min = 3, max = 20) String primerNombre, @NotBlank @Size(min = 3, max = 20) String segundoNombre, @NotBlank @Size(min = 3, max = 20) String primerApellido, @NotBlank @Size(min = 3, max = 20) String segundoApellido, @NotBlank @Size(min = 3, max = 20) String telefono, @NotBlank @Size(min = 3, max = 20) String direccion, @NotBlank @Size(min = 3, max = 20) String correoElectronico) {
        super(propietariosId, primerNombre, segundoNombre, primerApellido, segundoApellido, telefono, direccion, correoElectronico);
    }
}
