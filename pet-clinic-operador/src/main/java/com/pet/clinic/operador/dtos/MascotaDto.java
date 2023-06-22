package com.pet.clinic.operador.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MascotaDto {

    private String mascotasId;
    private String nombreMascota;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaNacimiento;
    private String tipoMascota;
}
