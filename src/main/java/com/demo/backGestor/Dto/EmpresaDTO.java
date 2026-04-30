package com.demo.backGestor.Dto;

import java.time.LocalDate;

public record EmpresaDTO (
    int idEmpresa,
    String email,
    String password,
    String nombre,
    String apellidos,
    String direccion,
    LocalDate fechaCreacion
){}
