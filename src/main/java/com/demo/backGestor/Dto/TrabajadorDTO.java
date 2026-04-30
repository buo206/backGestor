package com.demo.backGestor.Dto;

import java.sql.Date;
import java.time.LocalDate;

public interface TrabajadorDTO{
        int getIdTrabajador();
        String getNombre();
        String getApellidos();
        String getEmail();
        String getPassword() ;
        String getNumeroTelefono() ;
        String getDni();
        String getDirreccion();
        LocalDate getFechaCreacion();
}
