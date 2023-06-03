package com.pet.clinic.buscador.pojos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pet.clinic.buscador.models.entity.Propietario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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

    @NotBlank
    private Long conctatosId;
    @NotBlank
    private Propietario propietarioId;
    @NotBlank
    @Size(min = 8, max = 10)
    private String telefono;
    @NotBlank
    @Size(min = 5, max = 50)
    private String direccion;
    @NotBlank
    @Size(min = 50, max = 100)
    private String correoElectronico;
}
