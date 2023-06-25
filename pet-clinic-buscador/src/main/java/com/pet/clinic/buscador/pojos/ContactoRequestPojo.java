package com.pet.clinic.buscador.pojos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pet.clinic.buscador.models.entity.PropietarioElastic;

import lombok.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.io.Serializable;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
@RequestScope
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContactoRequestPojo implements Serializable {

    private Long conctatosId;
    private PropietarioElastic propietarioId;
    
    private String telefono;
    
    private String direccion;
    private String correoElectronico;
}
