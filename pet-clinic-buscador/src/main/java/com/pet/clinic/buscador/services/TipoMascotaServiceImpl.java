package com.pet.clinic.buscador.services;

import com.pet.clinic.buscador.enums.ResponseMessageEnum;
import com.pet.clinic.buscador.models.entity.TipoMascota;
import com.pet.clinic.buscador.pojos.ResponsePojo;
import com.pet.clinic.buscador.repository.ITipoMascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TipoMascotaServiceImpl implements ITipoMascotaService{

    @Autowired
    private ITipoMascotaRepository iTipoMascotaRepository;

    @Autowired
    private ResponsePojo responsePojo;
    @Override
    public ResponsePojo getTipoDeMascota() {

        List<TipoMascota> listTipoMascotas = new ArrayList<>();
        iTipoMascotaRepository.findAll().forEach(listTipoMascotas::add);

         if (listTipoMascotas.isEmpty()){
             responsePojo.setMessages(ResponseMessageEnum.MESSAGE_ERROR_NOT_FOUND_ENUM.toString());
         }else{
             responsePojo.setData(listTipoMascotas);
             responsePojo.setMessages(ResponseMessageEnum.MESSAGE_OK_ENUM.toString());
         }
        return responsePojo;
    }
}
