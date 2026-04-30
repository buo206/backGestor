package com.demo.backGestor.Service;

import com.demo.backGestor.ControllerRes.TrabajadorResController;
import com.demo.backGestor.Dto.TrabajadorDTO;
import com.demo.backGestor.Dto.TrabajadorListaDTO;
import com.demo.backGestor.Repository.TrabajadorRepository;
import com.demo.backGestor.Repository.TrabajoRepository;
import com.demo.backGestor.modelos.Empresa;
import com.demo.backGestor.modelos.Trabajador;
import com.demo.backGestor.modelos.Trabajo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TrabajadorService {
    private final TrabajadorRepository repo ;

    public TrabajadorService(TrabajadorRepository repo) {
        this.repo = repo;
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

    public TrabajadorDTO crear(Trabajador trabajador){
        return repo.findByEmail(trabajador.getEmail()).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST , "Ya hay un trabajador con ese email , por favor cambie el email")) ;
    }

    public TrabajadorDTO buscarId(int id) {
        Optional<Trabajador> trabajador =   repo.findById(id) ;

        if(trabajador.isPresent()){
            Trabajador t = trabajador.get();

            return new TrabajadorDTO(
                    t.getIdTrabajador(),
                    t.getEmpresa().getIdEmpresa() ,
                    t.getNombre(),
                    t.getApellidos(),
                    t.getEmail(),
                    t.getPassword(),
                    t.getNumeroTelefono(),
                    t.getDni(),
                    t.getDirreccion(),
                    t.getFechaCreacion()
            );
        }else{
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST , "No se ha encontrado ningun trabajador con este id ");
        }
    }
}
