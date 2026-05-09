package com.demo.backGestor.Service;

import com.demo.backGestor.Dto.TrabajoDTO;
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

    public List<TrabajoListaDTO> listar(int idEmpresa){
        Optional<Empresa> empresa = repoEmpresa.findById(idEmpresa);
        if(empresa.isPresent()){
            return repo.findByEmpresa_IdEmpresa(idEmpresa) ;
        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST , "No existe una empresa con este id ");
        }
    }

    public TrabajoDTO buscar(int idTrabajo){
        return repo.buscarPorIdTrabajador(idTrabajo).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST , " no se ha encontrado ningun trabajo / tarea con este id"));
    }

    public TrabajoDTO modificar(TrabajoDTO trabajo){
        Optional<Trabajo> comprobante = repo.findById(trabajo.idTrabajo());
        if(comprobante.isPresent()){
            Trabajo tr = new Trabajo();
            tr.setIdTrabajo(trabajo.idTrabajo());
            tr.setEmpresa(comprobante.get().getEmpresa());
            tr.setTitulo(trabajo.titulo());
            tr.setDescripcion(trabajo.descripcion());
            tr.setFechaFinal(trabajo.fechaFinal());
            tr.setFechaInicio(trabajo.fechaInicio());
            tr.setAnotacion(trabajo.anotacion());
            tr.setEstado(trabajo.estado());

            Trabajo resultado = repo.save(tr);
            return repo.buscarPorIdTrabajador(resultado.getIdTrabajo()).get();
        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST , "No existe un trabajo con esta id");
        }
    }

    public TrabajoDTO alta(TrabajoDTO trabajo){
        Optional<Trabajo> comprobante = repo.findById(trabajo.idTrabajo());
        if(comprobante.isEmpty()){
            Optional<Empresa> empresa = repoEmpresa.findById(trabajo.idEmpresa());
            if(empresa.isEmpty()){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No existe una empresa con esa id ");
            }
            Trabajo tr = new Trabajo();
            tr.setEmpresa(empresa.get());
            tr.setTitulo(trabajo.titulo());
            tr.setDescripcion(trabajo.descripcion());
            tr.setFechaFinal(trabajo.fechaFinal());
            tr.setFechaInicio(trabajo.fechaInicio());
            tr.setAnotacion(trabajo.anotacion());
            tr.setEstado(trabajo.estado());

            Trabajo resultado = repo.save(tr);
            return repo.buscarPorIdTrabajador(resultado.getIdTrabajo()).get();
        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST , "No existe un trabajo con esta id");
        }
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
