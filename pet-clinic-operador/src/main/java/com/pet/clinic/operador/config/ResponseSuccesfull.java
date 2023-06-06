package com.pet.clinic.operador.config;

import java.util.List;

public class ResponseSuccesfull<T> {
	private String		  message;
	private String		  code;
	private T			  data;
	private List<T> 	  listData;
}
