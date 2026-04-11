package com.demo.backGestor.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class RegistroTrabajoId implements Serializable {

    @Column(name = "ID_TRABAJO")
    private Integer idTrabajo;

    @Column(name = "ID_TRABAJADOR")
    private Integer idTrabajador;

    public RegistroTrabajoId() {}

    public RegistroTrabajoId(Integer idTrabajo, Integer idTrabajador) {
        this.idTrabajo = idTrabajo;
        this.idTrabajador = idTrabajador;
    }

    public Integer getIdTrabajo() {
        return idTrabajo;
    }

    public void setIdTrabajo(Integer idTrabajo) {
        this.idTrabajo = idTrabajo;
    }

    public Integer getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(Integer idTrabajador) {
        this.idTrabajador = idTrabajador;
    }
}
