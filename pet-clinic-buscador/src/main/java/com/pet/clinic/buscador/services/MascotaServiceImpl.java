package com.pet.clinic.buscador.services;

import com.pet.clinic.buscador.enums.ResponseMessageEnum;
import com.pet.clinic.buscador.models.dtos.MascotaDto;
import com.pet.clinic.buscador.models.entity.Mascota;
import com.pet.clinic.buscador.models.entity.Propietario;
import com.pet.clinic.buscador.models.entity.TipoMascota;
import com.pet.clinic.buscador.pojos.MascotaRequestPojo;
import com.pet.clinic.buscador.pojos.ResponsePojo;
import com.pet.clinic.buscador.repository.IMascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MascotaServiceImpl implements IMascotaService{

    @Autowired
    IMascotaRepository iMascotaRepository;
    @Autowired
    ResponsePojo responsePojo;
    private List<MascotaDto> mascotaDtoList;

    @Override
    public ResponsePojo getMascota() {

        this.mascotaDtoList = new ArrayList<>();
        this.mascotaDtoList = iMascotaRepository.getMascotasAntTipo();

        if(this.mascotaDtoList.isEmpty()){
            responsePojo.setMessages(ResponseMessageEnum.MESSAGE_ERROR_NOT_FOUND_ENUM.getMessages());
        }else{
            responsePojo.setMessages(ResponseMessageEnum.MESSAGE_OK_ENUM.getMessages());
            responsePojo.setData(this.mascotaDtoList);
        }
        return responsePojo;
    }

    @Override
    public ResponsePojo findMascotaById(Long mascotaId) {

        this.mascotaDtoList = new ArrayList<>();
        this.mascotaDtoList = iMascotaRepository.getMascotaPorIdAntTipo(mascotaId);
        if (mascotaDtoList.isEmpty()){
            responsePojo.setMessages(ResponseMessageEnum.MESSAGE_ERROR_NOT_FOUND_ENUM.getMessages());
        }else{
            responsePojo.setMessages(ResponseMessageEnum.MESSAGE_OK_ENUM.getMessages());
            responsePojo.setData(this.mascotaDtoList);
        }
        return this.responsePojo;
    }

    @Override
    public ResponsePojo saveMascota(MascotaRequestPojo mascota) {

        if (mascota != null){

            TipoMascota tipoMascota = TipoMascota.builder().tipoMascotasId(mascota.getTipoMascota().getTipoMascotasId()).build();
            Propietario propietario = Propietario.builder().propietariosId(mascota.getPropietario().getPropietariosId()).build();
            Mascota saveMascota = Mascota.builder().nombreMascota(mascota.getNombreMascota())
                    .fechaNacimiento(mascota.getFechaNacimiento()).tipoMascota(tipoMascota)
                    .propietario(propietario).build();

            Mascota responseMascota = iMascotaRepository.save(saveMascota);
            if (responseMascota != null){
                responsePojo.setData(responseMascota);
                responsePojo.setMessages(ResponseMessageEnum.MESSAGE_OK_ENUM.getMessages());
            }else {
                responsePojo.setMessages(ResponseMessageEnum.MESSAGE_ERROR_CAMPOS.getMessages());
            }
        }
        return responsePojo;
    }

    @Override
    public ResponsePojo updateMascota(MascotaRequestPojo mascota, Long mascotaId) {

        if (mascota != null){
            TipoMascota tipoMascota = TipoMascota.builder().tipoMascotasId(mascota.getTipoMascota().getTipoMascotasId()).build();
            Propietario propietario = Propietario.builder().propietariosId(mascota.getPropietario().getPropietariosId()).build();
            Mascota saveMascota = Mascota.builder().mascotasId(mascotaId).nombreMascota(mascota.getNombreMascota())
                    .fechaNacimiento(mascota.getFechaNacimiento()).tipoMascota(tipoMascota)
                    .propietario(propietario).build();

            Mascota responseMascota = iMascotaRepository.save(saveMascota);
            if (responseMascota != null){
                responsePojo.setData(responseMascota);
                responsePojo.setMessages(ResponseMessageEnum.MESSAGE_OK_ENUM.getMessages());
            }else {
                responsePojo.setMessages(ResponseMessageEnum.MESSAGE_ERROR_CAMPOS.getMessages());
            }
        }
        return responsePojo;
    }

    @Override
    public Boolean deleteMascota(Long mascotaId) {
        boolean response = false;
        if(iMascotaRepository.existsById(mascotaId)){
            iMascotaRepository.deleteById(mascotaId);
            response = true;
        }
        return response;
    }
}
