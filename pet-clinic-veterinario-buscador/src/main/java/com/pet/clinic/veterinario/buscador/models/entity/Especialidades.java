package com.pet.clinic.veterinario.buscador.models.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "tipo_especilidades")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Especialidades implements Serializable {

        private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(generator = "TIPO_ESPECIALIDAD", strategy = GenerationType.SEQUENCE)
        @SequenceGenerator(name = "TIPO_ESPECIALIDAD", sequenceName = "tipo_especialidades_tipo_especialidades_id_seq", allocationSize = 1)
        @Column(name = "especialidad_id", nullable = false)
        private Long EspecilidadId;
        @Column(name = "codigo_tipo", nullable = false)
        private Integer codigoTipo;
        @Column(name = "tipo_especialidad", nullable = false)
        private String tipoEspecialidad;
}
