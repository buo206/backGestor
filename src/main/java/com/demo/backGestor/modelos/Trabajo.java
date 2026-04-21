package com.demo.backGestor.modelos;

import jakarta.persistence.*;

import java.sql.Date;
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
    private Date fecha_Inicio ;

    @Column(name = "FECHA_FINAL" , nullable = false )
    private String fecha_Final ;

    @Column(name = "ANOTACION" , length = 300)
    private String anotacion;

    @Enumerated(EnumType.STRING)
    @Column(name = "ESTADO", length = 1, nullable = false)
    private Estado estado;


    public Trabajo(){

    }

    public int getId_Trabajo() {
        return idTrabajo;
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

    public Date getFecha_Inicio() {
        return fecha_Inicio;
    }

    public void setFecha_Inicio(Date fecha_Inicio) {
        this.fecha_Inicio = fecha_Inicio;
    }

    public String getFecha_Final() {
        return fecha_Final;
    }

    public void setFecha_Final(String fecha_Final) {
        this.fecha_Final = fecha_Final;
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

    public void setEstado(String estado) {
        this.estado = Estado.getEstado(estado) ;
    }
}


