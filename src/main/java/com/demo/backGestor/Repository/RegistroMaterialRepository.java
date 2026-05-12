package com.demo.backGestor.Repository;

import com.demo.backGestor.Dto.RegistroMaterialDTO;
import com.demo.backGestor.modelos.RegistroMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RegistroMaterialRepository extends JpaRepository<RegistroMaterial, Integer> {

    @Query(value = """
    SELECT 
        RM.ID_REGISTRO AS idRegistro,
        T.ID_TRABAJO AS idTrabajo,
        T.TITULO AS tituloTrabajo,
        M.ID_MATERIAL AS idMaterial,
        M.TITULO AS tituloMaterial,
        RM.ID_TRABAJADOR AS idTrabajador,
        TR.NOMBRE AS nombreTrabajador,
        RM.FECHA AS fecha,
        RM.CANTIDAD AS cantidad
    FROM REGISTRO_MATERIALES RM
    JOIN TRABAJOS T
        ON RM.ID_TRABAJO = T.ID_TRABAJO
    JOIN MATERIALES M
        ON RM.ID_MATERIAL = M.ID_MATERIAL
    JOIN TRABAJADORES TR
        ON RM.ID_TRABAJADOR = TR.ID_TRABAJADOR
    WHERE T.ID_EMPRESA = :idEmpresa ORDER BY RM.FECHA desc 
    """, nativeQuery = true)
    List<RegistroMaterialDTO> buscarPorEmpresa(@Param("idEmpresa") Integer idEmpresa);


    @Query(value = """
    SELECT 
        RM.ID_REGISTRO AS idRegistro,
        T.ID_TRABAJO AS idTrabajo,
        T.TITULO AS tituloTrabajo,
        M.ID_MATERIAL AS idMaterial,
        M.TITULO AS tituloMaterial,
        RM.ID_TRABAJADOR AS idTrabajador,
        TR.NOMBRE AS nombreTrabajador,
        RM.FECHA AS fecha,
        RM.CANTIDAD AS cantidad
    FROM REGISTRO_MATERIALES RM
    JOIN TRABAJOS T
        ON RM.ID_TRABAJO = T.ID_TRABAJO
    JOIN MATERIALES M
        ON RM.ID_MATERIAL = M.ID_MATERIAL
    JOIN TRABAJADORES TR
        ON RM.ID_TRABAJADOR = TR.ID_TRABAJADOR
    WHERE RM.ID_TRABAJO = :idTrabajo ORDER BY RM.FECHA desc 
    """, nativeQuery = true)
    List<RegistroMaterialDTO> buscarPorTrabajo(@Param("idTrabajo") Integer idTrabajo);

    @Query(value = """
    SELECT 
        RM.ID_REGISTRO AS idRegistro,
        T.ID_TRABAJO AS idTrabajo,
        T.TITULO AS tituloTrabajo,
        M.ID_MATERIAL AS idMaterial,
        M.TITULO AS tituloMaterial,
        RM.ID_TRABAJADOR AS idTrabajador,
        TR.NOMBRE AS nombreTrabajador ,
        RM.FECHA AS fecha,
        RM.CANTIDAD AS cantidad
    FROM REGISTRO_MATERIALES RM
    JOIN TRABAJOS T
        ON RM.ID_TRABAJO = T.ID_TRABAJO
    JOIN MATERIALES M
        ON RM.ID_MATERIAL = M.ID_MATERIAL
    JOIN TRABAJADORES TR
        ON RM.ID_TRABAJADOR = TR.ID_TRABAJADOR
    WHERE RM.ID_REGISTRO = :idRegistro ORDER BY RM.FECHA desc 
    """, nativeQuery = true)
    Optional<RegistroMaterialDTO> buscarPorIdRegistro(@Param("idRegistro") Integer idRegistro);


    @Query(value = """
    SELECT 
        RM.ID_REGISTRO AS idRegistro,
        T.ID_TRABAJO AS idTrabajo,
        T.TITULO AS tituloTrabajo,
        M.ID_MATERIAL AS idMaterial,
        M.TITULO AS tituloMaterial,
        RM.ID_TRABAJADOR AS idTrabajador,
        TR.NOMBRE AS nombreTrabajador ,
        RM.FECHA AS fecha,
        RM.CANTIDAD AS cantidad
    FROM REGISTRO_MATERIALES RM
    JOIN TRABAJOS T
        ON RM.ID_TRABAJO = T.ID_TRABAJO
    JOIN MATERIALES M
        ON RM.ID_MATERIAL = M.ID_MATERIAL
    JOIN TRABAJADORES TR
        ON RM.ID_TRABAJADOR = TR.ID_TRABAJADOR
    WHERE RM.ID_TRABAJADOR = :idTrabajador and  RM.ID_TRABAJO = :idTrabajo and RM.ID_MATERIAL = :idMaterial ORDER BY RM.FECHA desc 
    """, nativeQuery = true)
    Optional<RegistroMaterialDTO> buscarPorTrabajoTrabajadorMaterial(@Param("idTrabajador") Integer idTrabajador , @Param("idTrabajo") Integer idTrabajo , @Param("idMaterial") Integer idMaterial);


}
