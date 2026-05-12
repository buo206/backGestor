package com.demo.backGestor.Service;

import com.demo.backGestor.Dto.MaterialDTO;
import com.demo.backGestor.Dto.RegistroMaterialDTO;
import com.demo.backGestor.Repository.*;
import com.demo.backGestor.modelos.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class RegistroMaterialService {
    private final RegistroMaterialRepository repo ;
    private final EmpresaRepository repoEmpresa ;
    private final MaterialRepository repoMaterial ;
    private final TrabajoRepository repoTrabajo ;
    private final TrabajadorRepository repoTrabajador ;

    public RegistroMaterialService(RegistroMaterialRepository repo, EmpresaRepository repoEmpresa, MaterialRepository repoMaterial, TrabajoRepository repoTrabajo, TrabajadorRepository repoTrabajador) {
        this.repo = repo;
        this.repoEmpresa = repoEmpresa;
        this.repoMaterial = repoMaterial;
        this.repoTrabajo = repoTrabajo;
        this.repoTrabajador = repoTrabajador;
    }

    public List<RegistroMaterialDTO> listar(int idEmpresa){
        Optional<Empresa> empresa = repoEmpresa.findById(idEmpresa);
        if(empresa.isPresent()){
            return repo.buscarPorEmpresa(idEmpresa) ;
        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST , "No existe ninguna empresa con este id ");
        }
    }

    public List<RegistroMaterialDTO> buscarPorTrabajo(int idTrabajo){
        return repo.buscarPorTrabajo(idTrabajo) ;
    }


    public RegistroMaterialDTO buscarPorTrabajadorTrabajoMaterial(int idTrabajador , int idTrabajo , int idMaterial){
        return repo.buscarPorTrabajoTrabajadorMaterial(idTrabajador , idTrabajo , idMaterial).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST , "No existe ninguna registro de trabajo con estos ids "));
    }



    public RegistroMaterialDTO modificar(RegistroMaterialDTO registro){
        Optional<RegistroMaterial> comprobante = repo.findById(registro.idRegistro());
        if(comprobante.isPresent()){
            //sacamos el material para ver si hay que quitar stock al material o sumarle
            Optional<Material> material = repoMaterial.findById(registro.idMaterial());

            //creamos un nuevo material para modificarlo posteriarmente
            Material modificado = new Material();
            modificado.setIdMaterial(material.get().getIdMaterial());
            modificado.setEmpresa(material.get().getEmpresa());
            modificado.setTitulo(material.get().getTitulo());

            //comporbamos si hay que hay añadir strock al material o si hay que restarle
            if(registro.cantidad() > comprobante.get().getCantidad()){
                int cantidadRestar = registro.cantidad() - comprobante.get().getCantidad();
                if(material.get().getStock() < cantidadRestar){
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST , "No hay suficiente  stock del material con id "+material.get().getIdMaterial());
                }else{
                    modificado.setStock(material.get().getStock() - cantidadRestar);
                }
            }else{
                int cantidadSumar = comprobante.get().getCantidad() - registro.cantidad();
                modificado.setStock(material.get().getStock() + cantidadSumar);
            }

            //Actualizamos el material
            Material resultadoM = repoMaterial.save(modificado);

            RegistroMaterial rg = new RegistroMaterial();
            rg.setIdRegistro(registro.idRegistro());
            rg.setMaterial(resultadoM);
            rg.setTrabajo(comprobante.get().getTrabajo());
            rg.setTrabajador(comprobante.get().getTrabajador());
            rg.setCantidad(registro.cantidad());
            rg.setFecha(registro.fecha());

            RegistroMaterial resultado = repo.save(rg);
            return repo.buscarPorIdRegistro(resultado.getIdRegistro()).get();
        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST , "No existe ningun registro de materiales con este id ");
        }
    }

    public RegistroMaterialDTO nuevo(RegistroMaterialDTO registro){
        Optional<RegistroMaterial> comprobante = repo.findById(registro.idRegistro());
        if(comprobante.isEmpty()){
            //primero sacamos las claves foranes para  verificar que existan y así tenerlas para crear el registro posteriormente
            Optional<Trabajo> trabajo = repoTrabajo.findById(registro.idTrabajo());
            if(trabajo.isEmpty()){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST , "No existe el trabajo al que se le intenta agenciar un registro");
            }

            Optional<Trabajador> trabajador = repoTrabajador.findById(registro.idTrabajador());
            if(trabajador.isEmpty()){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST , "No existe el trabajador al que se le intenta agenciar un registro");
            }


            Optional<Material> material = repoMaterial.findById(registro.idMaterial());
            if(material.isEmpty()){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST , "No existe el material al que se le intenta agenciar un registro");
            }

            Material resultadoM ;

            if(registro.cantidad() > material.get().getStock()){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST , "No hay suficiente stock");
            }else{
                Material obtenido =material.get();
                obtenido.setStock(obtenido.getStock() - registro.cantidad());
                resultadoM = repoMaterial.save(obtenido);
            }

            RegistroMaterial rg = new RegistroMaterial();
            rg.setMaterial(resultadoM);
            rg.setTrabajo(trabajo.get());
            rg.setTrabajador(trabajador.get());
            rg.setCantidad(registro.cantidad());
            rg.setFecha(registro.fecha());

            RegistroMaterial resultado = repo.save(rg);
            return repo.buscarPorIdRegistro(resultado.getIdRegistro()).get();
        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST , "No existe ningun registro de materiales con este id ");
        }
    }
}
