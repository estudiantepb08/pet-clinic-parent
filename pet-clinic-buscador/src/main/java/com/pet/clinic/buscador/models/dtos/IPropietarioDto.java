package com.pet.clinic.buscador.models.dtos;

public interface IPropietarioDto {
    Long getPropietariosId();
    String getPrimerNombre();
    String getSegundoNombre();
    String getPrimerApellido();
    String getSegundoApellido();
    String getTelefono();
    String getDireccion();
    String getCorreoElectronico();
}