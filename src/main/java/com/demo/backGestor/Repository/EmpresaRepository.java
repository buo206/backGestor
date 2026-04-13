package com.demo.backGestor.Repository;

import com.demo.backGestor.modelos.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa , Integer> {
}
