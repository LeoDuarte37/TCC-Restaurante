package com.restaurante.grupo07.infrastructure.model.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Perfil {

    ROOT ("ROOT"),
    ADMIN ("ADMIN"),
    CAIXA ("CAIXA"),
    GARCOM ("GARCOM"),
    COZINHA ("COZINHA");

    private String nivel;

    Perfil(String nivel) {
        this.nivel = nivel;
    }

    public static Perfil doNivel (String nivel) {
        return switch (nivel) {
            case "ADMIN" -> ADMIN;
            case "CAIXA" -> CAIXA;
            case "GARCOM" -> GARCOM;
            case "COZINHA" -> COZINHA;
            default -> null;
        };
    }

    @JsonValue
    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
}
