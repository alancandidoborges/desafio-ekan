package com.ekan.enums;

import lombok.Getter;

@Getter
public enum Message {
    RECORD_ALREADY_EXISTS("Registro já existente."),
    RECORD_DELETED("Registro deletado com sucesso."),
    RECORD_NOT_FOUND("Registro não encontrado."),
    RECORD_NOT_SAVED("Erro ao incluir o registro."),
    RECORD_NOT_UPDATED("Erro ao atualizar o registro."),
    RECORD_SUCCESS("Registro Incluido com sucesso."),
    RECORD_UPDATED("Registro atualizado com sucesso."),
    ERROR_DELETE_RECORD("Erro ao deletar o Registro."),
    ERROR_SAVE_RECORD("Erro ao salvar o registro."),
    ERROR_LIST_RECORD("Erro ao realizar a busca."),
    ERROR_INVALID_VALUE("Json no formato invalido.");

    private final String message;
    private Message(String message) {
        this.message = message;
    }

    public String toString() {
        return message;
    }
}
