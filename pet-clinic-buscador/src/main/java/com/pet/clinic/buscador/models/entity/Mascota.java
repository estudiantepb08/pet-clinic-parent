package com.pet.clinic.buscador.models.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "mascotas")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Mascota implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "MASCOTA_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "MASCOTA_SEQ", sequenceName = "mascotas_mascotas_id_seq", allocationSize = 1)
    @Column(name = "mascotas_id", nullable = false)
    private Long mascotasId;
    @Column(name = "nombre_mascota", nullable = false)
    private String nombreMascota;
    @Column(name = "fecha_nacimiento", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaNacimiento;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="tipo_mascotas_id")
    private TipoMascota tipoMascotasId;
}
