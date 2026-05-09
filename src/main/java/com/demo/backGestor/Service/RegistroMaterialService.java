package com.demo.backGestor.Service;

import com.demo.backGestor.Dto.RegistroMaterialDTO;
import com.demo.backGestor.Repository.EmpresaRepository;
import com.demo.backGestor.Repository.RegistroMaterialRepository;
import com.demo.backGestor.modelos.Empresa;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class RegistroMaterialService {
    private final RegistroMaterialRepository repo ;
    private final EmpresaRepository repoEmpresa ;

    public RegistroMaterialService(RegistroMaterialRepository repo, EmpresaRepository repoEmpresa) {
        this.repo = repo;
        this.repoEmpresa = repoEmpresa;
    }

    public List<RegistroMaterialDTO> listar(int idEmpresa){
        Optional<Empresa> empresa = repoEmpresa.findById(idEmpresa);
        if(empresa.isPresent()){
            return repo.buscarPorEmpresa(idEmpresa) ;
        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST , "No existe ninguna empresa con este id ");
        }
    }
}
