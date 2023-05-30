package com.pet.clinic.buscador.pojos;

import lombok.*;

import java.io.Serializable;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PropietarioRequestPojo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long propietariosId;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    //private List<MascotaRequestPojo> mascotas = new ArrayList<>();
    private ContactoRequestPojo contacto;
}
