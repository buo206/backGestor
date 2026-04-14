package com.demo.backGestor.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RegistroMaterialId implements Serializable {
    @Column(name = "ID_MATERIAL")
    private Integer idMateril ;

    @Column(name = "ID_TRABAJO")
    private Integer idTrabajo ;

    public RegistroMaterialId(Integer idMateril , Integer idTrabajo) {
        this.idMateril = idMateril;
        this.idTrabajo = idTrabajo;
    }

    public Integer getIdMateril() {
        return idMateril;
    }

    public void setIdMateril(Integer idMateril) {
        this.idMateril = idMateril;
    }

    public Integer getIdTrabajo() {
        return idTrabajo;
    }

    public void setIdTrabajo(Integer idTrabajo) {
        this.idTrabajo = idTrabajo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        RegistroMaterialId that = (RegistroMaterialId) o;
        return Objects.equals(idMateril, that.idMateril) && Objects.equals(idTrabajo, that.idTrabajo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMateril, idTrabajo);
    }
}
