package com.pet.clinic.veterinario.buscador.models.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Document(indexName = "specialties", createIndex = true)
@Builder
@Getter
@Setter
@AllArgsConstructor
public class VeterinarioElastic {

	@Id
    private String id;
	@Field(type = FieldType.Integer, name = "veterinarioId")
	private Long   veterinarioId;
	@Field(type = FieldType.Text, name = "primerNombreVet")
    private String primerNombreVet;
	@Field(type = FieldType.Text, name = "segundoNombreVet")
    private String segundoNombreVet;
	@Field(type = FieldType.Text, name = "primerApellidoVet")
    private String primerApellidoVet;
	@Field(type = FieldType.Text, name = "segundoApellidoVet")
	private String segundoApellidoVet;
	@Field(type = FieldType.Object, name = "especialidad")
	private EspecialidadElastic especialidad;

}
