package com.demo.backGestor.Dto;

import java.sql.Date;
import java.time.LocalDate;

public record TrabajadorDTO(
        int idTrabajador ,
        int idEmpresa,
        String nombre,
        String apellidos,
        String email,
        String password,
        String numeroTelefono,
        String dni,
        String dirreccion,
        LocalDate fechaCreacion
) {}
