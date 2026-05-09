package com.demo.backGestor.Dto;

import java.time.LocalDateTime;

public record RegistroMaterialDTO(
        int idRegistro ,
        int idTrabajo ,
        String tituloTrabajo ,
        int idMaterial,
        String tituloMaterial ,
        int idTrabajador ,
        String nombreTrabajador ,
        LocalDateTime fecha ,
        int cantidad
) {}
