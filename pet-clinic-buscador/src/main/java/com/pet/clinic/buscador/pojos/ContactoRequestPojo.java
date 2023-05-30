package com.pet.clinic.buscador.pojos;

import com.pet.clinic.buscador.models.entity.Propietario;
import lombok.*;

import java.io.Serializable;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactoRequestPojo implements Serializable {
    private Long conctatosId;
    private Propietario propietarioId;
    private String telefono;
    private String direccion;
    private String correoElectronico;
}
