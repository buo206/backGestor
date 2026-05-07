package com.demo.backGestor.Repository;

import com.demo.backGestor.Dto.MaterialDTO;
import com.demo.backGestor.modelos.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MaterialRepository extends JpaRepository<Material, Integer> {
    @Query("""
    SELECT new com.demo.backGestor.Dto.MaterialDTO(
        m.idMaterial,
        m.empresa.idEmpresa ,
        m.titulo,
        m.stock
    )
    FROM Material m WHERE m.idMaterial = :id """)
    Optional<MaterialDTO> buscarPorIdMaterial(int id);


    @Query("""
    SELECT new com.demo.backGestor.Dto.MaterialDTO(
        m.idMaterial,
        m.empresa.idEmpresa ,
        m.titulo,
        m.stock
    )
    FROM Material m WHERE m.empresa.idEmpresa = :id """)
    List<MaterialDTO> findByEmpresa_IdEmpresa(int id );

}
