package com.restaurante.grupo07.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

public enum StatusPedido {
    REALIZADO ("R", "REALIZADO"),
    PRONTO ("P", "PRONTO"),
    ENTREGUE ("E", "ENTREGUE");

    private String status;

    private StatusPedido(String status) {
        this.status = status;
    }

    public static StatusPedido doStatus (String status) {
        if (status.equals("R")) {
            return REALIZADO;
        } else if (status.equals("P")) {
            return PRONTO;
        } else if (status.equals("E")) {
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
