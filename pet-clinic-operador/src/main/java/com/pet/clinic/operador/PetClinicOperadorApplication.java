package com.pet.clinic.operador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class PetClinicOperadorApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetClinicOperadorApplication.class, args);
	}
    @Bean
    public RestTemplate getrestTemplate() {
        return new RestTemplate();
    }

}
