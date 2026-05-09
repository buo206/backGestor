package com.demo.backGestor.Repository;

import com.demo.backGestor.Dto.RegistroTrabajoDTO;
import com.demo.backGestor.modelos.RegistroTrabajo;
import com.demo.backGestor.modelos.RegistroTrabajoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RegistroTrabajoRepository extends JpaRepository<RegistroTrabajo, RegistroTrabajoId> {

    @Query("""
    SELECT new com.demo.backGestor.Dto.RegistroTrabajoDTO(
        rt.trabajo.idTrabajo,
        rt.trabajo.titulo,
        rt.trabajador.idTrabajador,
        rt.trabajador.nombre,
        rt.trabajador.apellidos,
        rt.rol
    )
    FROM RegistroTrabajo rt
    WHERE rt.trabajo.empresa.idEmpresa = :idEmpresa
    ORDER BY rt.trabajo.idTrabajo, rt.trabajador.nombre
    """)
    List<RegistroTrabajoDTO> buscarPorEmpresa(int idEmpresa);

    @Query("""
    SELECT new com.demo.backGestor.Dto.RegistroTrabajoDTO(
        rt.trabajo.idTrabajo,
        rt.trabajo.titulo,
        rt.trabajador.idTrabajador,
        rt.trabajador.nombre,
        rt.trabajador.apellidos,
        rt.rol
    )
    FROM RegistroTrabajo rt
    WHERE rt.trabajo.idTrabajo = :idTrabajo
    ORDER BY rt.trabajador.nombre
    """)
    List<RegistroTrabajoDTO> buscarPorTrabajo(int idTrabajo);

    @Query("""
    SELECT new com.demo.backGestor.Dto.RegistroTrabajoDTO(
        rt.trabajo.idTrabajo,
        rt.trabajo.titulo,
        rt.trabajador.idTrabajador,
        rt.trabajador.nombre,
        rt.trabajador.apellidos,
        rt.rol
    )
    FROM RegistroTrabajo rt
    WHERE rt.trabajo.idTrabajo = :idTrabajo
      AND rt.trabajador.idTrabajador = :idTrabajador
    """)
    Optional<RegistroTrabajoDTO> buscarPorId(int idTrabajo, int idTrabajador);
}
