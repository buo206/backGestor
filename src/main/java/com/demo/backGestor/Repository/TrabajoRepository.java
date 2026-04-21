package com.demo.backGestor.Repository;

import com.demo.backGestor.modelos.Trabajador;
import com.demo.backGestor.modelos.Trabajo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrabajoRepository extends JpaRepository<Trabajo, Integer> {
    List<Trabajo> findByEmpresa_IdEmpresa(int id );

}
