package com.demo.backGestor.Dto;

import java.time.LocalDate;

public interface TrabajadorAltaDTO {
    int getIdTrabajador();
    int getIdEmpresa();
    String getNombre();
    String getApellidos();
    String getEmail();
    String getPassword() ;
    String getNumeroTelefono() ;
    String getDni();
    String getDirreccion();
    LocalDate getFechaCreacion();
}
