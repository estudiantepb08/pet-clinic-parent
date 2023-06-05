package com.pet.clinic.veterinario.buscador.configuracion;


import com.pet.clinic.veterinario.buscador.pojos.ResponsePojo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguracionVet {
    @Bean
    public ResponsePojo responsePojo(){ return new ResponsePojo(); }
    
}
