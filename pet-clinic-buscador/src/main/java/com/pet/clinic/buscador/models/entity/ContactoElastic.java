package com.pet.clinic.buscador.models.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Document(indexName = "owners", createIndex = true)
@Builder
@Getter
@Setter
@AllArgsConstructor
public class ContactoElastic {

	@Id
    private String conctatosId;
	@Field(type = FieldType.Search_As_You_Type, name = "telefono")
    private String telefono;
	@Field(type = FieldType.Search_As_You_Type, name = "direccion")
    private String direccion;
	@Field(type = FieldType.Search_As_You_Type, name = "correoElectronico")
    private String correoElectronico;


}
