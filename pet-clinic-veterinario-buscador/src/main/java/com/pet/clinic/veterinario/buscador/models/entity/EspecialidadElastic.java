package com.pet.clinic.veterinario.buscador.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Document(indexName = "veterinaries", createIndex = true)
@Builder
@Getter
@Setter
@AllArgsConstructor
public class EspecialidadElastic {
	 @Id
     private String especialidadId;
	@Field(type = FieldType.Integer, name = "codigoEspecialidad")
     private Integer codigoEspecialidad;
 	@Field(type = FieldType.Text, name = "tipoEspecialidad")
     private String tipoEspecialidad;
	@Field(type = FieldType.Text, name = "descripcionTipo")
     private String descripcionTipo;
}
