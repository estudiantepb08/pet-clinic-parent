package com.pet.clinic.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class PetClinicGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetClinicGatewayApplication.class, args);
	}

}
