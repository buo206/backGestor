package com.demo.backGestor.Repository;

import com.demo.backGestor.Dto.TrabajadorDTO;
import com.demo.backGestor.Dto.TrabajoDTO;
import com.demo.backGestor.Dto.TrabajoListaDTO;
import com.demo.backGestor.modelos.Trabajador;
import com.demo.backGestor.modelos.Trabajo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TrabajoRepository extends JpaRepository<Trabajo, Integer> {
    @Query("""
    SELECT new com.demo.backGestor.Dto.TrabajoDTO(
        t.idTrabajo,
        t.empresa.idEmpresa,
        t.titulo,
        t.descripcion,
        t.fechaInicio,
        t.fechaFinal,
        t.anotacion,
        t.estado
    )
    FROM Trabajo t WHERE t.idTrabajo = :id """)
    Optional<TrabajoDTO> buscarPorIdTrabajo(int id);


    @Query("""
    SELECT new com.demo.backGestor.Dto.TrabajoListaDTO(
        t.idTrabajo,
        t.titulo,
        t.estado
    )
    FROM Trabajo t WHERE t.idTrabajo in (SELECT RT.trabajo.idTrabajo FROM RegistroTrabajo RT WHERE RT.trabajador.idTrabajador = :id) """)
    List<TrabajoListaDTO> buscarPorIdTrabajador(int id);

    List<TrabajoListaDTO> findByEmpresa_IdEmpresa(int id );

}
