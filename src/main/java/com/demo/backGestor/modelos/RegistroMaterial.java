package com.demo.backGestor.modelos;

import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name="REGISTRO_MATERIALES")
public class RegistroMaterial {
    @EmbeddedId
    private RegistroMaterialId id ;

    @ManyToOne
    @MapsId("idTrabajo")
    @JoinColumn(name = "ID_TRABAJO")
    private Trabajo trabajo;

    @ManyToOne
    @MapsId("idMaterial")
    @JoinColumn(name = "ID_MATERIAL")
    private Material material ;

    @Column(name = "CANTIDAD" , length = 10)
    private int cantidad;

    @Column(name = "FECHA")
    private Date fecha ;

    public RegistroMaterialId getId() {
        return id;
    }

    public void setId(RegistroMaterialId id) {
        this.id = id;
    }

    public Trabajo getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(Trabajo trabajo) {
        this.trabajo = trabajo;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDate getFecha() {
        return fecha.toLocalDate();
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
