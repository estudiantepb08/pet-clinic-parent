package com.pet.clinic.veterinario.buscador.pojos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.context.annotation.Scope;

import java.io.Serializable;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Scope("Prototype")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponsePojo implements Serializable {

    private String messages;
    private Object data;
}
