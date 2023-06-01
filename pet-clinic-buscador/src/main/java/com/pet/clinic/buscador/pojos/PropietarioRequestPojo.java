package com.pet.clinic.buscador.pojos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PropietarioRequestPojo implements Serializable {

    private static final long serialVersionUID = 1L;

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
    //private List<MascotaRequestPojo> mascotas = new ArrayList<>();
    @NotBlank
    @Size(min = 3, max = 20)
    private ContactoRequestPojo contacto;
}
