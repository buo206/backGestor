package com.demo.backGestor.modelos;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.HashMap;

@Entity
@Table(name= "TRABAJOS")
public class Trabajo {
    /*
    * CREATE TABLE TRABAJOS (
    ID_TRABAJO INT AUTO_INCREMENT PRIMARY KEY,
    ID_EMPRESA INT,
    TITULO VARCHAR(50) NOT NULL,
    DESCRIPCION VARCHAR(200),
    FECHA_INICIO DATE NOT NULL,
    FECHA_FINAL DATE NOT NULL,
    ANOTACION VARCHAR(300),
    ESTADO VARCHAR(1),
    CONSTRAINT FK_TRABAJO_EMPRESA
        FOREIGN KEY (ID_EMPRESA) REFERENCES EMPRESAS(ID_EMPRESA)
);*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TRABAJO")
    private int id_Trabajo;

    private HashMap<Trabajador , String> trabajadores ;

    @Column(name = "TITULO" , nullable = false , length = 50)
    private String titulo ;

    @Column(name = "DESCRIPCION" ,  length = 200)
    private String descripcion ;

    @Column(name = "FECHA_INICIO" , nullable = false )
    private Date fecha_Inicio ;

    @Column(name = "FECHA_FINAL" , nullable = false )
    private String fecha_Final ;

}
