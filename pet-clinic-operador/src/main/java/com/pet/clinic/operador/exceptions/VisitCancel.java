package com.pet.clinic.operador.exceptions;

public class VisitCancel extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public VisitCancel(String message) {
		
		super(message);
	}
}
