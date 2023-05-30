package com.pet.clinic.buscador.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "contactos")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Contacto implements Serializable {

    @Id
    @GeneratedValue(generator = "CONTATO_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "CONTATO_SEQ", sequenceName = "contactos_conctatos_id_seq", allocationSize = 1)
    @Column(name = "conctatos_id")
    private Long conctatosId;
    @JsonIgnoreProperties({"propietariosId", "hibernateLazyInitializer", "handler"})
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "propietarios_id", nullable = false)
    private Propietario propietariosId;
    @Column(name = "telefono", nullable = false, length = 10)
    private String telefono;
    @Column(name = "direccion", nullable = false, length = 50)
    private String direccion;
    @Column(name = "correo_electronico", nullable = false, length = 100)
    private String correoElectronico;
}
