package com.utc;

public class Cliente {
    private String idTicket;
    private String nombre;
    private String motivo;

    public Cliente(String idTicket, String nombre, String motivo) {
        this.idTicket = idTicket;
        this.nombre = nombre;
        this.motivo = motivo;
    }

    public String getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(String idTicket) {
        this.idTicket = idTicket;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    @Override
    public String toString() {
        return "Ticket: " + idTicket + " | Cliente: " + nombre + " | Motivo: " + motivo;
    }
}
