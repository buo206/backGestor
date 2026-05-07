package com.demo.backGestor.modelos;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;


import java.time.LocalDate;
import java.util.HashMap;

@Entity
@Table(name= "TRABAJOS")
public class Trabajo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TRABAJO")
    private int idTrabajo;

    @ManyToOne
    @JoinColumn(name = "ID_EMPRESA")
    private Empresa empresa ;

    @Column(name = "TITULO" , nullable = false , length = 50)
    private String titulo ;

    @Column(name = "DESCRIPCION" ,  length = 200)
    private String descripcion ;

    @Column(name = "FECHA_INICIO" , nullable = false )
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fechaInicio ;

    @Column(name = "FECHA_FINAL" , nullable = true )
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fechaFinal ;

    @Column(name = "ANOTACION" , length = 300)
    private String anotacion;

    @Enumerated(EnumType.STRING)
    @Column(name = "ESTADO", length = 1, nullable = false)
    private Estado estado;


    public Trabajo(){

    }

    public int getIdTrabajo() {
        return idTrabajo;
    }
    public void setIdTrabajo(int idTrabajo) {
        this.idTrabajo = idTrabajo;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fecha_Inicio) {
        this.fechaInicio = fecha_Inicio;
    }

    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(LocalDate fecha_Final) {
        this.fechaFinal = fecha_Final;
    }

    public String getAnotacion() {
        return anotacion;
    }

    public void setAnotacion(String anotacion) {
        this.anotacion = anotacion;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado ;
    }
}


