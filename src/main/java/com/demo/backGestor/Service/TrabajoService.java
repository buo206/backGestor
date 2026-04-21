package com.demo.backGestor.Service;

import com.demo.backGestor.Dto.TrabajoListaDTO;
import com.demo.backGestor.Repository.TrabajoRepository;
import com.demo.backGestor.modelos.Trabajo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TrabajoService {
    private final TrabajoRepository repo ;

    public TrabajoService(TrabajoRepository repo) {
        this.repo = repo;
    }

    public List<TrabajoListaDTO> lista(int idEmpresa){
        List<Trabajo> aux = repo.findByEmpresa_IdEmpresa(idEmpresa) ;
        ArrayList<TrabajoListaDTO> resultado = new ArrayList<>();
        if(!aux.isEmpty()){
            for(Trabajo tr : aux){
                resultado.add(new TrabajoListaDTO(tr.getId_Trabajo() , tr.getTitulo() , tr.getEstado().toString()));
            }
        }

        return resultado ;
    }

    public Trabajo buscar(int idTrabajo){
        return repo.findById(idTrabajo).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST , " no se ha encontrado ningun trabajo / tarea con este id"));
    }

    public Trabajo guardar(Trabajo tr){
        return repo.save(tr);
    }
}
