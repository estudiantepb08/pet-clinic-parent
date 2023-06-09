package com.pet.clinic.buscador.pojos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pet.clinic.buscador.models.entity.TipoMascota;
import lombok.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.io.Serializable;
import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
@RequestScope
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MascotaRequestPojo implements Serializable {

    private Long mascotasId;
    private String nombreMascota;
    private Date fechaNacimiento;
    private TipoMascotaRequestPojo tipoMascota;
    private PropietarioRequestPojo propietario;
}
