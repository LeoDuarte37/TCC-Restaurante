package com.restaurante.grupo07.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

public enum StatusMesa {
    DISPONIVEL ("D"),
    ABERTA ("A"),
    PENDENTE ("P");

    private String status;

    private StatusMesa (String status) { this.status = status; }

    public static StatusMesa doStatus (String status) {
        if (status.equals("D") || status.equals("DISPONIVEL")) {
            return DISPONIVEL;
        } else if (status.equals("A") || status.equals("ABERTA")) {
            return ABERTA;
        } else if (status.equals("P") || status.equals("PENDENTE")) {
            return PENDENTE;
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
