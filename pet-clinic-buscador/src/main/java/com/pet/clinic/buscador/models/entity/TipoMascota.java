package com.pet.clinic.buscador.models.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "tipo_mascotas")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TipoMascota implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(generator = "TIPO_MASCOTA", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "TIPO_MASCOTA", sequenceName = "tipo_mascotas_tipo_mascotas_id_seq", allocationSize = 1)
    @Column(name = "tipo_mascotas_id", nullable = false)
    private Long tipoMascotasId;
    @Column(name = "codigo_tipo", nullable = false)
    private Integer codigoTipo;
    @Column(name = "tipo_mascota", nullable = false)
    private String tipoMascota;
    @Column(name = "descripcion_tipo", nullable = false)
    private String descripcionTipo;
}
