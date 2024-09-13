package com.restaurante.grupo07.infrastructure.model.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

public enum StatusMesa {
    DISPONIVEL ("D"),
    ABERTA ("A"),
    PENDENTE ("P");

    private String status;

    StatusMesa (String status) { this.status = status; }

    public static StatusMesa doStatus (String status) {
        return switch (status) {
            case "D", "DISPONIVEL" -> DISPONIVEL;
            case "A", "ABERTA" -> ABERTA;
            case "P", "PENDENTE" -> PENDENTE;
            default -> null;
        };
    }

    @JsonValue
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
