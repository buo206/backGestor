package com.demo.backGestor.Repository;

import com.demo.backGestor.Dto.MaterialListaDTO;
import com.demo.backGestor.Dto.TrabajadorDTO;
import com.demo.backGestor.modelos.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MaterialRepository extends JpaRepository<Material, Integer> {
    @Query("""
    SELECT new com.demo.backGestor.Dto.MaterialListaDTO(
        m.idMaterial,
        m.titulo,
        m.stock
    )
    FROM Material m WHERE m.idMaterial = :id """)
    Optional<MaterialListaDTO> buscarPorIdMaterial(int id);

    List<MaterialListaDTO> findByEmpresa_IdEmpresa(int id );

}
