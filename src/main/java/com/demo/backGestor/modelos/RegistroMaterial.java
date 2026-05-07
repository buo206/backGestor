package com.demo.backGestor.modelos;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="REGISTRO_MATERIALES")
public class RegistroMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_REGISTRO")
    private Integer idRegistro;

    @ManyToOne
    @JoinColumn(name = "ID_TRABAJO", nullable = false)
    private Trabajo trabajo;

    @ManyToOne
    @JoinColumn(name = "ID_MATERIAL", nullable = false)
    private Material material ;

    @ManyToOne
    @JoinColumn(name = "ID_TRABAJADOR", nullable = false)
    private Trabajador trabajador;

    @Column(name = "CANTIDAD", nullable = false)
    private int cantidad;

    @Column(name = "FECHA", insertable = false, updatable = false)
    private LocalDateTime fecha ;

    public Integer getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(Integer idRegistro) {
        this.idRegistro = idRegistro;
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

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}
