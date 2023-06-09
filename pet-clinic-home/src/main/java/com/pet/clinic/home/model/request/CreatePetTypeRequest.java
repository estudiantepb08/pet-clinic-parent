package com.pet.clinic.home.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreatePetTypeRequest {

    @JsonProperty("tipo_mascota_id")
    private Long petId;

    @JsonProperty("tipo_mascota")
    private String shortDescription;

    @JsonProperty("descripcion_tipo")
    private String largeDescription;

    public Long getPetId() {
        return petId;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getLargeDescription() {
        return largeDescription;
    }

}
