package com.demo.backGestor.modelos;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "Empresas")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_EMPRESA")
    private int id_Empresa ;

    @Email
    @Column(name = "EMAIL" , nullable = false , length = 255)
    private String email ;

    @Column(name = "PASSWORD" , nullable = false , length = 50)
    private String password ;

    @Column(name = "NOMBRE" , length = 30)
    private String nombre ;

    @Column(name = "APELLIDOS" , length = 50)
    private String apellidos ;

    @Column(name = "DIRECCION" , length = 90)
    private String direccion;

    @Column(name = "FECHA_CREACION" , nullable = false )
    private Date fecha_Creacion;

    public Empresa() {
    }

    public int getId_Empresa() {
        return id_Empresa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDirreccion() {
        return direccion;
    }

    public void setDirreccion(String dirreccion) {
        this.direccion = dirreccion;
    }

    public LocalDate getFecha_Creacion() {
        return fecha_Creacion.toLocalDate();
    }

    public void setFecha_Creacion(Date fecha_Creacion) {
        this.fecha_Creacion = fecha_Creacion;
    }
}
