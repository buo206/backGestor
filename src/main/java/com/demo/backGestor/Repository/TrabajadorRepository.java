package com.demo.backGestor.Repository;

import com.demo.backGestor.modelos.Empresa;
import com.demo.backGestor.modelos.Trabajador;
import com.demo.backGestor.modelos.Trabajo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TrabajadorRepository extends JpaRepository<Trabajador, Integer> {
    Optional<Trabajador> findByEmailAndPassword(String email , String password);
    Optional<Trabajador> findByEmail(String email);
    List<Trabajador> findByEmpresa_IdEmpresa(int id );
}
