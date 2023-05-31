package com.pet.clinic.veterinario.buscador.models.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "veterinarios")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Veterinario implements Serializable {

    @Id
    @GeneratedValue(generator = "VETERINARIO_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "VETERINARIO_SEQ", sequenceName = "veterinarios_veterinarios_id_seq", allocationSize = 1)
    @Column(name = "veterinario_id", nullable = false)
    private Long veterinarioId;
    @Column(name = "primer_nombre_vet", nullable = false)
    private String primerNombreVet;
    @Column(name = "segundo_nombre_vet")
    private String segundoNombreVet;
    @Column(name = "primer_apellido_vet", nullable = false)
    private String primerApellidoVet;
    @Column(name = "segundo_apellido_vet")
    private String segundoApellidoVet;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "especilidades_id")
    private List<Especialidades> mascotasId = new ArrayList<>();
    @JsonIgnoreProperties({"veterinariosId", "hibernateLazyInitializer", "handler"})
    @OneToMany(mappedBy = "veterinariosId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ContactoVet> contactoId = new ArrayList<>();
}
