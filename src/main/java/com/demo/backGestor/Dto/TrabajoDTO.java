package com.demo.backGestor.Dto;

import com.demo.backGestor.modelos.Estado;

import java.time.LocalDate;

public record TrabajoDTO(
        int idTrabajo,
        int idEmpresa ,
        String titulo ,
        String descripcion ,
        LocalDate fechaInicio ,
        LocalDate fechaFinal ,
        String anotacion ,
        Estado estado
) {
}
