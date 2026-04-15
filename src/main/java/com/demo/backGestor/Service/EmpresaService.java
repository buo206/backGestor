package com.demo.backGestor.Service;

import com.demo.backGestor.Repository.EmpresaRepository;
import com.demo.backGestor.modelos.Empresa;
import org.springframework.stereotype.Service;
import tools.jackson.databind.node.StringNode;

import java.util.Optional;

@Service
public class EmpresaService {
    private final EmpresaRepository repo ;

    public EmpresaService(EmpresaRepository repo) {
        this.repo = repo;
    }

    public Empresa buscarId(int id){
        return  repo.findById(id).orElseThrow(() -> new RuntimeException("No se ha podido encontrar")) ;
    }

    public Empresa validarEmailPassword(String email , String password){
        return  repo.findByEmailAndPassword(email , password).orElseThrow(() -> new RuntimeException("No se ha podido encontrar ninguna empresa , password o email incorrecto"));
    }

    public Empresa crear(Empresa empresa){
        Optional<Empresa> resultado = repo.findByEmail(empresa.getEmail()) ;

        if(resultado.isEmpty()){
            return repo.save(empresa) ;
        }else {
            throw  new RuntimeException("Ya existe una empresa con ese email");
        }

    }
}
