package com.demo.backGestor.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        RegistroTrabajoId that = (RegistroTrabajoId) o;
        return Objects.equals(idTrabajo, that.idTrabajo) && Objects.equals(idTrabajador, that.idTrabajador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTrabajo, idTrabajador);
    }
}
