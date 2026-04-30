package com.demo.backGestor.Dto;

import java.time.LocalDate;

public interface EmpresaDTO {
    int getIdEmpresa();
    String getEmail();
    String getPassword();
    String getNombre();
    String getApellidos();
    String getDireccion();
    LocalDate getFechaCreacion();
}
