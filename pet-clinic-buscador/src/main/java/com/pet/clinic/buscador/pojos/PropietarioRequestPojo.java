package com.pet.clinic.buscador.pojos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.web.context.annotation.RequestScope;

import java.io.Serializable;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequestScope
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PropietarioRequestPojo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    
    private Long propietariosId;
    
    private String primerNombre;
    
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private ContactoRequestPojo contacto;
}
