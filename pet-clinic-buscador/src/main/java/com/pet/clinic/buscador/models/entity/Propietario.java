package com.pet.clinic.buscador.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "propietarios", schema = "petclinicbuscadordb")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Propietario implements Serializable {

    @Id
    @GeneratedValue(generator = "PROPIETARIO_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "PROPIETARIO_SEQ", sequenceName = "propietarios_propietarios_id_seq", allocationSize = 1)
    @Column(name = "propietarios_id", nullable = false)
    private Long propietariosId;
    @Column(name = "primer_nombre", nullable = false)
    private String primerNombre;
    @Column(name = "segundo_nombre")
    private String segundoNombre;
    @Column(name = "primerApellido")
    private String primerApellido;
    @Column(name = "segundo_apellido")
    private String segundoApellido;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "mascotas_id")
    private List<Mascota> mascotasId = new ArrayList<>();
    @JsonIgnoreProperties({"propietariosId", "hibernateLazyInitializer", "handler"})
    @OneToMany(mappedBy = "propietariosId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Contacto> contactoId = new ArrayList<>();
}
