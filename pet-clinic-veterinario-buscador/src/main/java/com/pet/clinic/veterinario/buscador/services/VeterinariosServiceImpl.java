package com.pet.clinic.veterinario.buscador.services;

import com.pet.clinic.veterinario.buscador.enums.ResponseMessageEnum;
import com.pet.clinic.veterinario.buscador.models.dto.BuscarTodosLab;
import com.pet.clinic.veterinario.buscador.models.dto.VeterinarioDto;
import com.pet.clinic.veterinario.buscador.models.entity.Especialidad;
import com.pet.clinic.veterinario.buscador.models.entity.Veterinario;
import com.pet.clinic.veterinario.buscador.pojos.EspecialidadRequestPojo;
import com.pet.clinic.veterinario.buscador.pojos.VeterinariosRequestPojo;
import com.pet.clinic.veterinario.buscador.pojos.ResponsePojo;
import com.pet.clinic.veterinario.buscador.repository.IVererinarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class VeterinariosServiceImpl implements IVeterinarioService {
    
    @Autowired
    IVererinarioRepository iVeterinarioRepository;

	@Autowired
	ResponsePojo responsePojo;
	private List<Veterinario> veterinarios;

    @Override
	public ResponsePojo getVeterinario() {

		this.veterinarios = new ArrayList<>();

		iVeterinarioRepository.findAll().forEach(veterinarios::add); // pendiente repository
		if (veterinarios.isEmpty()) {
			responsePojo.setMessages(ResponseMessageEnum.MESSAGE_ERROR_NOT_FOUND_ENUM.getMessages());
		} else {
			responsePojo.setMessages(ResponseMessageEnum.MESSAGE_OK_ENUM.getMessages());
			responsePojo.setData(this.veterinarios);
		}
	return responsePojo;
	}

	@Override
	public ResponsePojo findVeterinarioById(Long veterinarioId) {

		Optional<Veterinario> optionalVeterionario = iVeterinarioRepository.findById(veterinarioId); // pendiente repository
		if (optionalVeterionario.isPresent()) {
			responsePojo.setMessages(ResponseMessageEnum.MESSAGE_OK_ENUM.getMessages());
			responsePojo.setData(optionalVeterionario.get());
		} else {
			responsePojo.setMessages(ResponseMessageEnum.MESSAGE_ERROR_NOT_FOUND_ENUM.getMessages());
		}
		return responsePojo;
		}


		// revisar funcionamiento
	@Override
	public ResponsePojo saveVeterinario(VeterinariosRequestPojo veterinariosRequestPojo) {



		if(veterinariosRequestPojo != null && StringUtils.hasLength(veterinariosRequestPojo.getPrimerNombreVet().trim())
				|| (StringUtils.hasLength(veterinariosRequestPojo.getSegundoNombreVet().trim())
				|| StringUtils.hasLength(veterinariosRequestPojo.getSegundoApellidoVet().trim()))
				&& StringUtils.hasLength(veterinariosRequestPojo.getPrimerApellidoVet().trim())
				&& !veterinariosRequestPojo.getEspecialidad().getEspecialidadId().equals(0))
				{


				Veterinario veterinario = Veterinario.builder()
						.primerNombreVet(veterinariosRequestPojo.getPrimerNombreVet().trim())
						.segundoNombreVet(veterinariosRequestPojo.getSegundoNombreVet().trim())
						.primerApellidoVet(veterinariosRequestPojo.getPrimerApellidoVet().trim())
						.segundoApellidoVet(veterinariosRequestPojo.getSegundoApellidoVet().trim())
						.especialidadId(Especialidad.builder().especialidadId(veterinariosRequestPojo.getEspecialidad().getEspecialidadId()).build())
						.build();

					Veterinario saveVeterinario = iVeterinarioRepository.save(veterinario);

				if(saveVeterinario != null){
					responsePojo.setData(saveVeterinario);
					responsePojo.setMessages(ResponseMessageEnum.MESSAGE_OK_ENUM.getMessages());
				}
		}else{
			responsePojo.setMessages(ResponseMessageEnum.MESSAGE_ERROR_NOT_FOUND_ENUM.getMessages());
		}

		return responsePojo;
	}

	@Override
	@Transactional
	public ResponsePojo updateVeterinario(VeterinariosRequestPojo veterinariosRequestPojo, Long veterinarioId) {

		Optional<Veterinario> optionalVeterionarioup = iVeterinarioRepository.findById(veterinarioId);

		if (optionalVeterionarioup.isPresent()) {
			if (veterinariosRequestPojo != null && StringUtils.hasLength(veterinariosRequestPojo.getPrimerNombreVet().trim())
					|| (StringUtils.hasLength(veterinariosRequestPojo.getSegundoNombreVet().trim())
					|| StringUtils.hasLength(veterinariosRequestPojo.getSegundoApellidoVet().trim()))
					&& StringUtils.hasLength(veterinariosRequestPojo.getPrimerApellidoVet().trim())
					&& !veterinariosRequestPojo.getEspecialidad().getEspecialidadId().equals(0)) {


				Veterinario veterinario = Veterinario.builder().veterinarioId(veterinarioId)
						.primerNombreVet(veterinariosRequestPojo.getPrimerNombreVet().trim())
						.segundoNombreVet(veterinariosRequestPojo.getSegundoNombreVet().trim())
						.primerApellidoVet(veterinariosRequestPojo.getPrimerApellidoVet().trim())
						.segundoApellidoVet(veterinariosRequestPojo.getSegundoApellidoVet().trim())
						.especialidadId(Especialidad.builder().especialidadId(veterinariosRequestPojo.getEspecialidad().getEspecialidadId()).build())
						.build();

				Veterinario saveVeterinario = iVeterinarioRepository.save(veterinario);

				if (saveVeterinario != null) {
					responsePojo.setData(saveVeterinario);
					responsePojo.setMessages(ResponseMessageEnum.MESSAGE_OK_ENUM.getMessages());
				}
			} else {
				responsePojo.setMessages(ResponseMessageEnum.MESSAGE_ERROR_NOT_FOUND_ENUM.getMessages());
			}
		}else{
			responsePojo.setMessages(ResponseMessageEnum.MESSAGE_ERROR_NOT_FOUND_ENUM.getMessages());
		}

		return responsePojo;
	}

	@Override
	public ResponsePojo deleteVeterinario(Long veterinarioId) {

		if(veterinarioId!= null){
			iVeterinarioRepository.deleteById(veterinarioId);
			responsePojo.setMessages(ResponseMessageEnum.MESSAGE_OK_ENUM.getMessages());
		}else{
			responsePojo.setMessages(ResponseMessageEnum.MESSAGE_ERROR_NOT_FOUND_ENUM.getMessages());
		}

		return responsePojo;
	}

	@Override
	public ResponsePojo getListarTodo(String buscar) {
		List<BuscarTodosLab> respuesta = iVeterinarioRepository.listBuscarTodoVet(buscar);
		if (respuesta.isEmpty()){
            responsePojo.setMessages(ResponseMessageEnum.MESSAGE_ERROR_NOT_FOUND_ENUM.getMessages());
        }else{
                responsePojo.setMessages(ResponseMessageEnum.MESSAGE_OK_ENUM.getMessages());
                responsePojo.setData(respuesta);
        }
        return responsePojo;
	}
    
}
