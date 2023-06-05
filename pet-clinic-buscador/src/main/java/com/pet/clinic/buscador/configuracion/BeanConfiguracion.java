package com.pet.clinic.buscador.configuracion;

import com.pet.clinic.buscador.pojos.ContactoRequestPojo;
import com.pet.clinic.buscador.pojos.ResponsePojo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BeanConfiguracion {

    @Bean
    @Scope("prototype")
    public ResponsePojo responsePojo(){ return new ResponsePojo(); }
    @Bean
    @Scope("prototype")
    public ContactoRequestPojo contacto(){return new ContactoRequestPojo();}
}
