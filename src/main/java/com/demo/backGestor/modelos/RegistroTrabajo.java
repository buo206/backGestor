package com.demo.backGestor.modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "REGISTRO_TRABAJADORES")
public class RegistroTrabajo {

    @EmbeddedId
    private RegistroTrabajoId id;

    @ManyToOne
    @MapsId("idTrabajo")
    @JoinColumn(name = "ID_TRABAJO")
    private Trabajo trabajo;

    @ManyToOne
    @MapsId("idTrabajador")
    @JoinColumn(name = "ID_TRABAJADOR")
    private Trabajador trabajador;

    @Column(name = "ROL" , length = 30)
    private String rol;

    public RegistroTrabajo() {}

    public RegistroTrabajo(Trabajo trabajo, Trabajador trabajador, String rol) {
        this.id = new RegistroTrabajoId(trabajo.getId_Trabajo(), trabajador.getId_Trabajador());
        this.trabajo = trabajo;
        this.trabajador = trabajador;
        this.rol = rol;
    }


    public RegistroTrabajoId getId() {
        return id;
    }

    public void setId(RegistroTrabajoId id) {
        this.id = id;
    }

    public Trabajo getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(Trabajo trabajo) {
        this.trabajo = trabajo;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}

