package com.demo.backGestor.Repository;

import com.demo.backGestor.Dto.TrabajadorDTO;
import com.demo.backGestor.Dto.TrabajadorListaDTO;
import com.demo.backGestor.modelos.Empresa;
import com.demo.backGestor.modelos.Trabajador;
import com.demo.backGestor.modelos.Trabajo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TrabajadorRepository extends JpaRepository<Trabajador, Integer> {
    Optional<TrabajadorDTO> findByEmailAndPassword(String email , String password);
    Optional<TrabajadorDTO> findByEmail(String email);
    List<TrabajadorListaDTO> findByEmpresa_IdEmpresa(int id );
}
