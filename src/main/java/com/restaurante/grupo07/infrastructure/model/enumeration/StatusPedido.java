package com.restaurante.grupo07.infrastructure.model.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

public enum StatusPedido {
    REALIZADO ("R"),
    FEITO ("F"),
    ENTREGUE ("E"),
    PAGO ("P");

    private String status;

    private StatusPedido(String status) {
        this.status = status;
    }

    public static StatusPedido doStatus (String status) {
        if (status.equals("R") || status.equals("REALIZADO")) {
            return REALIZADO;
        } else if (status.equals("F") || status.equals("FEITO")) {
            return FEITO;
        } else if (status.equals("E") || status.equals("ENTREGUE")) {
            return ENTREGUE;
        } else if (status.equals("P") || status.equals("PAGO")) {
            return PAGO;
        } else {
            return null;
        }
    }

    @JsonValue
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
