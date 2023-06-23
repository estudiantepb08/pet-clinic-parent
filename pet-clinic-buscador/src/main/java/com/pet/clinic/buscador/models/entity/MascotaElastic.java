package com.pet.clinic.buscador.models.entity;

import java.util.Date;

import jakarta.persistence.Id;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Document(indexName = "pets", createIndex = true)
@Builder
@Getter
@Setter
@AllArgsConstructor
public class MascotaElastic {

	@Id
    private String id;
	@Field(type = FieldType.Integer, name = "mascotasId")
    private Long mascotasId;
 	@Field(type = FieldType.Text, name = "nombreMascota")
    private String nombreMascota;
	@Field(type = FieldType.Date, name = "fechaNacimiento")
    private Date fechaNacimiento;
	@Field(type = FieldType.Object, name = "propietario")
    private PropietarioElastic propietario;
	@Field(type = FieldType.Object, name = "tipoMascota")
    private TipoMascotaElastic tipoMascota;


}
