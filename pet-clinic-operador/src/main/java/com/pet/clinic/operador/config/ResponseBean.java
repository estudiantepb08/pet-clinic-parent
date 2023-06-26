package com.pet.clinic.operador.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class ResponseBean {
	
	@Bean
	public <T> ResponseSuccesfull<T> MessageSuccesfull() {
	
		return new ResponseSuccesfull<T>();
		}
	}
