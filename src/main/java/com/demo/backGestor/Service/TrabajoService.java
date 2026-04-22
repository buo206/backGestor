package com.demo.backGestor.Service;

import com.demo.backGestor.Dto.TrabajoListaDTO;
import com.demo.backGestor.Repository.EmpresaRepository;
import com.demo.backGestor.Repository.TrabajoRepository;
import com.demo.backGestor.modelos.Empresa;
import com.demo.backGestor.modelos.Trabajo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TrabajoService {
    private final TrabajoRepository repo ;
    private final EmpresaRepository repoEmpresa ;

    public TrabajoService(TrabajoRepository repo, EmpresaRepository repoEmpresa) {
        this.repo = repo;
        this.repoEmpresa = repoEmpresa;
    }

    public List<TrabajoListaDTO> lista(int idEmpresa){
        List<Trabajo> aux = repo.findByEmpresa_IdEmpresa(idEmpresa) ;
        ArrayList<TrabajoListaDTO> resultado = new ArrayList<>();
        if(!aux.isEmpty()){
            for(Trabajo tr : aux){
                resultado.add(new TrabajoListaDTO(tr.getIdTrabajo() , tr.getTitulo() , tr.getEstado()));
            }
        }

        return resultado ;
    }

    public Trabajo buscar(int idTrabajo){
        return repo.findById(idTrabajo).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST , " no se ha encontrado ningun trabajo / tarea con este id"));
    }

    public Trabajo nuevo(int idEmpresa){
        Optional<Empresa> em = repoEmpresa.findById(idEmpresa) ;
        if(em.isPresent()){
            Trabajo tr  = new Trabajo() ;
            tr.setEmpresa(em.get());
            tr.setFechaInicio(LocalDate.now());
            return tr ;
        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST , "no se ha encontrado ninguna empresa con esa id ");
        }
    }

    public Trabajo guardar(Trabajo tr){
        return repo.save(tr);
    }

    public void eliminar(int idTrabajo){
        repo.deleteById(idTrabajo);
    }
}
