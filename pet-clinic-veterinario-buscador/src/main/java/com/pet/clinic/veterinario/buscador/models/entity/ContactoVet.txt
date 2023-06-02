package com.pet.clinic.veterinario.buscador.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pet.clinic.buscador.models.entity.Propietario;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "contactosvet")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactoVet implements Serializable {

    @Id
    @GeneratedValue(generator = "CONTATOVET_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "CONTATOVET_SEQ", sequenceName = "contactosvet_conctatosvet_id_seq", allocationSize = 1)
    @Column(name = "conctatosvet_id")
    private Long conctatosVetId;
    @JsonIgnoreProperties({"veterinariosId", "hibernateLazyInitializer", "handler"})
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "veterinarios_id", nullable = false)
    private Propietario propietariosId;
    @Column(name = "telefono_veterinario", nullable = false, length = 10)
    private String telefono_veterinario;
    @Column(name = "direccion_veterinario", nullable = false, length = 50)
    private String direccion_veterinario;
    @Column(name = "correo_electronico_veterinario", nullable = false, length = 100)
    private String correoElectronico_veterinario;
}
