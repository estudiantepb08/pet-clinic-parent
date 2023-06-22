package com.pet.clinic.buscador.pojos;

import com.fasterxml.jackson.annotation.JsonInclude;
import javax.validation.constraints.*;
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

    @NotBlank
    private String id;
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
    private ContactoRequestPojo contacto;
}
