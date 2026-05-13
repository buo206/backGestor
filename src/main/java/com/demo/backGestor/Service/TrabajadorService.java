package com.demo.backGestor.Service;

import com.demo.backGestor.Dto.TrabajadorDTO;
import com.demo.backGestor.Dto.TrabajadorListaDTO;
import com.demo.backGestor.Repository.EmpresaRepository;
import com.demo.backGestor.Repository.TrabajadorRepository;
import com.demo.backGestor.modelos.Empresa;
import com.demo.backGestor.modelos.Trabajador;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class TrabajadorService {
    private final TrabajadorRepository repo ;
    private final EmpresaRepository repoEmpresa ;

    public TrabajadorService(TrabajadorRepository repo, EmpresaRepository repoEmpresa) {
        this.repo = repo;
        this.repoEmpresa = repoEmpresa;
    }

    public TrabajadorDTO validarEmailPassword(String email , String password){
        return repo.findByEmailAndPassword(email , password).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email o password incorectos , no se ha encontrado nigun trabajador"));
    }


    //traer directamente la lista de TrabajadorListaDTO
    public List<TrabajadorListaDTO> listar(int id ){
        List<TrabajadorListaDTO> lista =  repo.findByEmpresa_IdEmpresa(id);

        if(lista.isEmpty()){throw  new ResponseStatusException(HttpStatus.BAD_REQUEST , "No se ha encontrado ningun trabajadro en esta emrpresa");}
        return lista;
    }

    public TrabajadorDTO crear(TrabajadorDTO trabajador){
        Optional<TrabajadorDTO> comprobante = repo.findByEmail(trabajador.email());
        if(comprobante.isEmpty()){
            Optional<Empresa> comprobarEmpresa = repoEmpresa.findById(trabajador.idEmpresa());
            if(comprobarEmpresa.isEmpty()){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST , "No existe una empresa con ese id ");
            }
            Trabajador tr = new Trabajador();
            tr.setEmpresa(comprobarEmpresa.get());
            tr.setEmail(trabajador.email());
            tr.setPassword(trabajador.password());
            tr.setApellidos(trabajador.apellidos());
            tr.setNombre(trabajador.nombre());
            tr.setNumeroTelefono(trabajador.numeroTelefono());
            tr.setDni(trabajador.dni());
            tr.setDirreccion(trabajador.dirreccion());
            tr.setFechaCreacion(trabajador.fechaCreacion());

            Trabajador resultado = repo.save(tr);
            return repo.buscarPorIdTrabajador(resultado.getIdTrabajador()).get();

        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST , "Ya hay un trabajador con ese email , por favor cambie el email");
        }
    }

    public TrabajadorDTO modificar(TrabajadorDTO trabajador){
        Optional<TrabajadorDTO> comprobanteExtra = repo.findByEmail(trabajador.email());
        if(comprobanteExtra.isPresent()){
            if(comprobanteExtra.get().idTrabajador() != trabajador.idTrabajador()){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST , "Ya hay un trabajador con ese email , por favor cambie el email");
            }
        }

        Optional<TrabajadorDTO> comprobante = repo.buscarPorIdTrabajador(trabajador.idTrabajador());
        if(comprobante.isPresent()){
            Optional<Empresa> comprobarEmpresa = repoEmpresa.findById(trabajador.idEmpresa());
            if(comprobarEmpresa.isEmpty()){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST , "No existe una empresa con ese id ");
            }
            Trabajador tr = new Trabajador();
            tr.setIdTrabajador(trabajador.idTrabajador());
            tr.setEmpresa(comprobarEmpresa.get());
            tr.setEmail(trabajador.email());
            tr.setPassword(trabajador.password());
            tr.setApellidos(trabajador.apellidos());
            tr.setNombre(trabajador.nombre());
            tr.setNumeroTelefono(trabajador.numeroTelefono());
            tr.setDni(trabajador.dni());
            tr.setDirreccion(trabajador.dirreccion());
            tr.setFechaCreacion(trabajador.fechaCreacion());

            Trabajador resultado = repo.save(tr);
            return repo.buscarPorIdTrabajador(resultado.getIdTrabajador()).get();

        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST , "No hay un trabajador con ese id");
        }
    }

    public TrabajadorDTO buscarId(int id) {
        return repo.buscarPorIdTrabajador(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST , "No se ha encontrado ningun trabajador con este id ")) ;

    }
}
