package com.restaurante.grupo07.infrastructure.model.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

public enum StatusPedido {
    REALIZADO ("R"),
    FEITO ("F"),
    ENTREGUE ("E"),
    PAGO ("P");

    private String status;

    StatusPedido(String status) {
        this.status = status;
    }

    public static StatusPedido doStatus (String status) {
        return switch (status) {
            case "R", "REALIZADO" -> REALIZADO;
            case "F", "FEITO" -> FEITO;
            case "E", "ENTREGUE" -> ENTREGUE;
            case "P", "PAGO" -> PAGO;
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
