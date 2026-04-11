package com.demo.backGestor.modelos;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

import java.sql.Date;
import java.time.LocalDate;


@Entity
@Table(name = "TRABAJADORES")
public class Trabajador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TRABAJADOR")
    private int id_Trabajador ;

    @ManyToOne
    @JoinColumn(name = "ID_EMPRESA")
    private Empresa empresa;

    @Column(name = "NOMBRE" , length = 30)
    private String nombre ;

    @Column(name = "APELLIDOS" , length = 50)
    private String apellidos ;

    @Email
    @Column(name = "EMAIL" , nullable = false , length = 255)
    private String email ;

    @Column(name = "PASSWORD" , nullable = false , length = 50)
    private String password ;

    @Column(name = "TELEFONO", length = 14)
    private String numeroTelefono;

    @Column(name = "DNI", length = 9)
    private String dni;

    @Column(name = "DIRECCION" , length = 90)
    private String dirreccion;

    @Column(name = "FECHA_CREACION" , nullable = false )
    private Date fecha_Creacion;

    public Trabajador(){

    }

    public int getId_Trabajador() {
        return id_Trabajador;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
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

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDirreccion() {
        return dirreccion;
    }

    public void setDirreccion(String dirreccion) {
        this.dirreccion = dirreccion;
    }

    public LocalDate getFecha_Creacion() {
        return fecha_Creacion.toLocalDate();
    }

    public void setFecha_Creacion(Date fecha_Creacion) {
        this.fecha_Creacion = fecha_Creacion;
    }
}
