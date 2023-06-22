package com.pet.clinic.buscador.models.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Document(indexName = "owners", createIndex = true)
@Builder
@Getter
@Setter
@AllArgsConstructor
public class PropietarioElastic {

	@Id
    private String id;
	@Field(type = FieldType.Integer, name = "propietariosId")
	private Long propietariosId;
	@Field(type = FieldType.Text, name = "primerNombre")
    private String primerNombre;
	@Field(type = FieldType.Text, name = "segundoNombre")
    private String segundoNombre;
	@Field(type = FieldType.Text, name = "primerApellido")
    private String primerApellido;
	@Field(type = FieldType.Text, name = "segundoApellido")
    private String segundoApellido;
	@Field(type = FieldType.Object, name = "contactoId")
    private List<ContactoElastic> contactoId = new ArrayList<>();

}
