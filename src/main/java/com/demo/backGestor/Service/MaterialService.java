package com.demo.backGestor.Service;

import com.demo.backGestor.Dto.MaterialDTO;
import com.demo.backGestor.Repository.MaterialRepository;
import com.demo.backGestor.modelos.Material;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialService {
    private final MaterialRepository repo ;

    public MaterialService(MaterialRepository repo) {
        this.repo = repo;
    }

    public List<MaterialDTO> listar(int idEmpresa){
        List<MaterialDTO> lista =  repo.findByEmpresa_IdEmpresa(idEmpresa) ;
        if(lista.isEmpty()){throw  new ResponseStatusException(HttpStatus.BAD_REQUEST , "No se ha encontrado ningun trabajadro en esta emrpresa");}
        return lista;
    }

    public MaterialDTO modificar(MaterialDTO material){
        Optional<Material> comprobante = repo.findById(material.idMaterial());
        if(comprobante.isPresent()){
            Material mat = new Material();
            mat.setEmpresa(comprobante.get().getEmpresa());
            mat.setIdMaterial(material.idMaterial());
            mat.setTitulo(material.titulo());
            mat.setStock(material.stock());

            Material resultado = repo.save(mat);
            return repo.buscarPorIdMaterial(resultado.getIdMaterial()).get();

        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST , "No hay un material con ese id");
        }
    }
}
