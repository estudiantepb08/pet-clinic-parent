package com.pet.clinic.operador.exceptions;

import java.time.LocalDateTime;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ExceptionResponse {

	private LocalDateTime dateTime;
	private String		  message;
	private String		  details;
	private Integer		  code;
	
}
