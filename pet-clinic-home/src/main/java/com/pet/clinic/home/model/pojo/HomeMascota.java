package com.pet.clinic.home.model.pojo;

import jakarta.persistence.*;
import lombok.*;
import java.sql.Timestamp;

@Entity
@Table(name = "tipo_mascotas")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class HomeMascota {
    @Id
    @GeneratedValue(generator = "", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "")

    @Column(name = "tipo_mascotas_id")
    private Long petTypeId;

    @Column(name = "tipo_mascota")
    private String shortDescription;

    @Column(name = "descripcion_tipo")
    private String largeDescription;

}
