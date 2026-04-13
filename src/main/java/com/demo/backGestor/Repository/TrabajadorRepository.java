package com.demo.backGestor.Repository;

import com.demo.backGestor.modelos.Empresa;
import com.demo.backGestor.modelos.Trabajador;
import com.demo.backGestor.modelos.Trabajo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrabajadorRepository extends JpaRepository<Trabajador, Integer> {
}
