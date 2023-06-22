package com.pet.clinic.buscador.services;

import com.pet.clinic.buscador.enums.ResponseMessageEnum;
import com.pet.clinic.buscador.models.entity.TipoMascota;
import com.pet.clinic.buscador.models.entity.TipoMascotaElastic;
import com.pet.clinic.buscador.pojos.ResponsePojo;
import com.pet.clinic.buscador.repository.DataAccessRepositoryTypePets;
import com.pet.clinic.buscador.repository.ITipoMascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TipoMascotaServiceImpl implements ITipoMascotaService{

    /*@Autowired
    private ITipoMascotaRepository iTipoMascotaRepository;*/

    @Autowired
    private DataAccessRepositoryTypePets iTipoMascotaRepository;
    @Autowired
    private ResponsePojo responsePojo;
    @Override
    public ResponsePojo getTipoDeMascota() {

        List<TipoMascotaElastic> listTipoMascotas = new ArrayList<>();

        iTipoMascotaRepository.findAll().forEach(listTipoMascotas::add);
         if (listTipoMascotas.isEmpty()){
             responsePojo.setMessages(ResponseMessageEnum.MESSAGE_ERROR_NOT_FOUND_ENUM.toString());
         }else{
             responsePojo.setData(listTipoMascotas);
             responsePojo.setMessages(ResponseMessageEnum.MESSAGE_OK_ENUM.toString());
         }
        return responsePojo;
    }
	@Override
	public ResponsePojo findByid(String id) {

		Optional<TipoMascotaElastic> tipoMascota = iTipoMascotaRepository.findById(id);
		if(tipoMascota.isEmpty()) {
            responsePojo.setMessages(ResponseMessageEnum.MESSAGE_ERROR_NOT_FOUND_ENUM.toString());
            responsePojo.setData(null);
		}else {
			responsePojo.setData(tipoMascota);
            responsePojo.setMessages(ResponseMessageEnum.MESSAGE_OK_ENUM.toString());

		}
		return responsePojo;
	}
}
