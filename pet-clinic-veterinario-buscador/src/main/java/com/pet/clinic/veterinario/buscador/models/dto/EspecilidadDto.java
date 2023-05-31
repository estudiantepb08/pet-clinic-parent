package com.pet.clinic.veterinario.buscador.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Data
@AllArgsConstructor
public class EspecilidadDto {

        private Long especialidadId;
        private String especialidad;

}
