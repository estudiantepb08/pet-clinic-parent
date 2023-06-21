package com.pet.clinic.veterinario.buscador.models.entity;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Document(indexName = "veterinaries", createIndex = true)
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
	private Especialidad especialidad;

}
