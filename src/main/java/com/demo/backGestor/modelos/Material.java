package com.demo.backGestor.modelos;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="MATERIALES")
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_MATERIAL")
    private int idMaterial ;

    @ManyToOne
    @JoinColumn(name = "ID_EMPRESA")
    private Empresa empresa;

    @Column(name = "TITULO" , nullable = false , length = 100)
    private String titulo ;

    @Column(name="STOCK" , length = 10)
    private int stock ;

    public Material(){

    }

    public void setIdMaterial(int idMaterial){this.idMaterial = idMaterial ;}
    public int getIdMaterial() {
        return idMaterial;
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
