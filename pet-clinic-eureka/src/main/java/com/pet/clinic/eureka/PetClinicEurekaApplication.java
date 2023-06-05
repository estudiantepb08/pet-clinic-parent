package com.pet.clinic.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class PetClinicEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetClinicEurekaApplication.class, args);
	}

}
