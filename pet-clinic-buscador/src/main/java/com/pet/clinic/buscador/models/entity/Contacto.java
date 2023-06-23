package com.pet.clinic.buscador.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;

import jakarta.persistence.*;

@Entity
@Table(name = "contactos")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Contacto implements Serializable {

    @Id
    @GeneratedValue(generator = "CONTATO_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "CONTATO_SEQ", sequenceName = "contactos_conctatos_id_seq", allocationSize = 1)
    @Column(name = "conctatos_id")
    private Long conctatosId;
    @JsonIgnoreProperties({"propietario", "hibernateLazyInitializer", "handler"})
    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.REFRESH }, fetch = FetchType.LAZY)
    @JoinColumn(name = "propietarios_id", nullable = false)
    private Propietario propietario;
    @Column(name = "telefono", nullable = false, length = 10)
    private String telefono;
    @Column(name = "direccion", nullable = false, length = 50)
    private String direccion;
    @Column(name = "correo_electronico", nullable = false, length = 100)
    private String correoElectronico;
}
