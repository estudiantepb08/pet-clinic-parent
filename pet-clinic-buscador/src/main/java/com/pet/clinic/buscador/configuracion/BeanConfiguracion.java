package com.pet.clinic.buscador.configuracion;

import com.pet.clinic.buscador.pojos.ResponsePojo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguracion {

    @Bean
    public ResponsePojo responsePojo(){ return new ResponsePojo(); }
}
