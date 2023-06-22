package com.pet.clinic.buscador.models.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Document(indexName = "pets_typing", createIndex = true)
@Builder
@Getter
@Setter
@AllArgsConstructor
public class TipoMascotaElastic {

	@Id
    private String id;

 	@Field(type = FieldType.Integer, name = "codigoTipo")
    private Integer codigoTipo;

 	@Field(type = FieldType.Keyword, name = "tipoMascota")
    private String tipoMascota;
 	@Field(type = FieldType.Text, name = "descripcionTipo")
    private String descripcionTipo;

}
