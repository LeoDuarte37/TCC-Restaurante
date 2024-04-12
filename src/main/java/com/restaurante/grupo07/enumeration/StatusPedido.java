package com.restaurante.grupo07.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

public enum StatusPedido {
    FEITO ("FEITO"),
    PRONTO ("PRONTO"),
    ENTREGUE ("ENTREGUE");

    private String status;

    private StatusPedido(String status) {
        this.status = status;
    }

    public static StatusPedido doStatus (String status) {
        if (status.equals("FEITO")) {
            return FEITO;
        } else if (status.equals("PRONTO")) {
            return PRONTO;
        } else if (status.equals("ENTREGUE")) {
            return ENTREGUE;
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
