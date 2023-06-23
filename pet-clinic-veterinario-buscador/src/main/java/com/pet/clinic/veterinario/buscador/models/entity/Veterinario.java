package com.pet.clinic.veterinario.buscador.models.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;


@Entity
@Table(name = "veterinario")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Veterinario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "VETERINARIO_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "VETERINARIO_SEQ", sequenceName = "veterinario_veterinario_id_seq", allocationSize = 1)
    @Column(name = "veterinario_id", nullable = false)
    private Long veterinarioId;
    @Column(name = "primer_nombrevet", nullable = false)
    private String primerNombreVet;
    @Column(name = "segundo_nombrevet")
    private String segundoNombreVet;
    @Column(name = "primer_apellidovet", nullable = false)
    private String primerApellidoVet;
    @Column(name = "segundo_apellidovet")
    private String segundoApellidoVet;
    @JsonIgnoreProperties({"especialidadId", "hibernateLazyInitializer", "handler"})
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "especialidades_id")
    private Especialidad especialidadId;
}
