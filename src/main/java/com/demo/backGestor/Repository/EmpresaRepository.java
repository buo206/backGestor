package com.demo.backGestor.Repository;

import com.demo.backGestor.Dto.EmpresaDTO;
import com.demo.backGestor.modelos.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmpresaRepository extends JpaRepository<Empresa , Integer> {

    Optional<EmpresaDTO> findByEmailAndPassword(String email , String password);
    Optional<Empresa> findByEmail(String email);
    Optional<EmpresaDTO> findByIdEmpresa(int idEmpresa);
}
