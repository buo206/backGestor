package com.demo.backGestor.modelos;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Empresas")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_EMPRESA")
    private int idEmpresa ;

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
    private LocalDate fechaCreacion;

    //relaciones OneToMany

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
    private List<Material> materiales;

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
    private List<Trabajador> trabajadores;

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
    private List<Trabajo> trabajos;


    public Empresa() {
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa= idEmpresa;
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

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fecha_Creacion) {
        this.fechaCreacion = fecha_Creacion;
    }

    public List<Material> getMateriales() {
        return materiales;
    }

    public void setMateriales(List<Material> materiales) {
        this.materiales = materiales;
    }

    public List<Trabajador> getTrabajadores() {
        return trabajadores;
    }

    public void setTrabajadores(List<Trabajador> trabajadores) {
        this.trabajadores = trabajadores;
    }

    public List<Trabajo> getTrabajos() {
        return trabajos;
    }

    public void setTrabajos(List<Trabajo> trabajos) {
        this.trabajos = trabajos;
    }
}
