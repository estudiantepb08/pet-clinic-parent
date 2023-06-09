package com.pet.clinic.veterinario.buscador.enums;

public enum ResponseMessageEnum {

    MESSAGE_ERROR_NOT_FOUND_ENUM("Error no se encotraron datos solicitados"),
    MESSAGE_OK_ENUM("Ok");

    private String messages;

    ResponseMessageEnum(String messages) {
        this.messages = messages;
    }

    public String getMessages() {
        return messages;
    }
}
