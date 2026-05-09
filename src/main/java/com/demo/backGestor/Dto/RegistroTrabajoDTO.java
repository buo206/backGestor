package com.demo.backGestor.Dto;

public record RegistroTrabajoDTO(
        int idTrabajo,
        String tituloTrabajo,
        int idTrabajador,
        String nombreTrabajador,
        String apellidosTrabajador,
        String rol
) {}
