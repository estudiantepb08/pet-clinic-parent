package com.pet.clinic.veterinario.buscador.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.pet.clinic.veterinario.buscador.pojos.ResponsePojo;
import com.pet.clinic.veterinario.buscador.pojos.VeterinariosRequestPojo;

public class VeterinariosServiceImpl implements IVeterinarioService {
    
    @Autowired
    IVeterinarioService iVeterinarioRepository;

	@Override
	public ResponsePojo getVeterinario() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getVeterinario'");
	}

	@Override
	public ResponsePojo findVeterinarioById(Long veterinarioId) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'findVeterinarioById'");
	}

	@Override
	public ResponsePojo saveVeterinario(VeterinariosRequestPojo veterinario) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'saveVeterinario'");
	}

	@Override
	public ResponsePojo updateVeterinario(VeterinariosRequestPojo veterinario, Long venerarioId) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'updateVeterinario'");
	}

	@Override
	public Boolean deleteVeterinario(Long veterinarioId) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'deleteVeterinario'");
	}
    
}
