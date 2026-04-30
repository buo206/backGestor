package com.demo.backGestor.Service;

import com.demo.backGestor.Dto.EmpresaDTO;
import com.demo.backGestor.Repository.EmpresaRepository;
import com.demo.backGestor.modelos.Empresa;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import tools.jackson.databind.node.StringNode;

import java.util.Optional;

@Service
public class EmpresaService {
    private final EmpresaRepository repo ;

    public EmpresaService(EmpresaRepository repo) {
        this.repo = repo;
    }

    public EmpresaDTO buscarId(int id){
        return  repo.findByIdEmpresa(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,"No se ha encontrado ninguna empresa")) ;
    }

    public EmpresaDTO validarEmailPassword(String email , String password){
        return  repo.findByEmailAndPassword(email , password).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST , "No se ha podido encontrar ninguna empresa , password o email incorrecto"));
    }

    public EmpresaDTO crear(EmpresaDTO empresa){
        Optional<Empresa> resultado = repo.findByEmail(empresa.getEmail()) ;

        if(resultado.isEmpty()){
            Empresa empresaX = new Empresa();
            empresaX.setFechaCreacion(empresa.getFechaCreacion());
            empresaX.setApellidos(empresa.getApellidos());
            empresaX.setDirreccion(empresa.getDireccion());
            empresaX.setNombre(empresa.getNombre());

            Empresa resultX = repo.save(empresaX);
            return this.buscarId(resultX.getIdEmpresa());
        }else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ya existe una empresa con ese email");
        }

    }
}
