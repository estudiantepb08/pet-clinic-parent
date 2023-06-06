package com.pet.clinic.buscador.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
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
    @JsonIgnoreProperties({"propietario", "hibernateLazyInitializer", "handler"})
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "propietarios_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Propietario propietario;
    @JsonIgnoreProperties({"tipoMascota", "hibernateLazyInitializer", "handler"})
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="tipo_mascotas_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private TipoMascota tipoMascota;
}
