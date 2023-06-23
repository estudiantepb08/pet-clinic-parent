package com.pet.clinic.veterinario.buscador.models.entity;

import lombok.*;
import java.io.Serializable;

import jakarta.persistence.*;

@Entity
@Table(name = "especialidades")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Especialidad implements Serializable {

        private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(generator = "TIPO_ESPECIALIDAD", strategy = GenerationType.SEQUENCE)
        @SequenceGenerator(name = "TIPO_ESPECIALIDAD", sequenceName = "especialidades_especialidades_id_seq", allocationSize = 1)

        @Column(name = "especialidades_id", nullable = false)
        private Long especialidadId;

        @Column(name = "codigo_especialidad", nullable = false)
        private Integer codigoEspecialidad;

        @Column (name = "tipo_especialidad", nullable = false)
        private String tipoEspecialidad;
        @Column(name = "descripcion_tipo", nullable = false)
        private String descripcionTipo;
}
