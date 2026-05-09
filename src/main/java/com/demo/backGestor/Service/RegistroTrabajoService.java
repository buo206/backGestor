package com.demo.backGestor.Service;

import com.demo.backGestor.Dto.RegistroTrabajoDTO;
import com.demo.backGestor.Repository.EmpresaRepository;
import com.demo.backGestor.Repository.RegistroTrabajoRepository;
import com.demo.backGestor.Repository.TrabajadorRepository;
import com.demo.backGestor.Repository.TrabajoRepository;
import com.demo.backGestor.modelos.Empresa;
import com.demo.backGestor.modelos.RegistroTrabajo;
import com.demo.backGestor.modelos.RegistroTrabajoId;
import com.demo.backGestor.modelos.Trabajador;
import com.demo.backGestor.modelos.Trabajo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class RegistroTrabajoService {
    private final RegistroTrabajoRepository repo;
    private final EmpresaRepository repoEmpresa;
    private final TrabajoRepository repoTrabajo;
    private final TrabajadorRepository repoTrabajador;

    public RegistroTrabajoService(RegistroTrabajoRepository repo, EmpresaRepository repoEmpresa, TrabajoRepository repoTrabajo, TrabajadorRepository repoTrabajador) {
        this.repo = repo;
        this.repoEmpresa = repoEmpresa;
        this.repoTrabajo = repoTrabajo;
        this.repoTrabajador = repoTrabajador;
    }

    public List<RegistroTrabajoDTO> listar(int idEmpresa) {
        Optional<Empresa> empresa = repoEmpresa.findById(idEmpresa);
        if (empresa.isPresent()) {
            return repo.buscarPorEmpresa(idEmpresa);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No existe ninguna empresa con este id");
        }
    }

    public List<RegistroTrabajoDTO> buscarPorTrabajo(int idTrabajo) {
        Optional<Trabajo> trabajo = repoTrabajo.findById(idTrabajo);
        if (trabajo.isPresent()) {
            return repo.buscarPorTrabajo(idTrabajo);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No existe ningun trabajo con este id");
        }
    }

    public List<RegistroTrabajoDTO> buscarPorTrabajador(int idTrabajador) {
        Optional<Trabajo> trabajo = repoTrabajo.findById(idTrabajador);
        if (trabajo.isPresent()) {
            return repo.buscarPorTrabajador(idTrabajador);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No existe ningun trabajador con este id");
        }
    }

    public RegistroTrabajoDTO buscar(int idTrabajo, int idTrabajador) {
        return repo.buscarPorId(idTrabajo, idTrabajador)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "No existe ningun registro de trabajo con estos ids"));
    }

    public RegistroTrabajoDTO nuevo(RegistroTrabajoDTO registro) {
        RegistroTrabajoId id = new RegistroTrabajoId(registro.idTrabajo(), registro.idTrabajador());
        Optional<RegistroTrabajo> comprobante = repo.findById(id);
        if (comprobante.isEmpty()) {
            Trabajo trabajo = repoTrabajo.findById(registro.idTrabajo())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "No existe el trabajo al que se le intenta agenciar un registro"));

            Trabajador trabajador = repoTrabajador.findById(registro.idTrabajador())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "No existe el trabajador al que se le intenta agenciar un registro"));

            if (trabajo.getEmpresa().getIdEmpresa() != trabajador.getEmpresa().getIdEmpresa()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El trabajador no pertenece a la empresa del trabajo");
            }

            RegistroTrabajo rg = new RegistroTrabajo();
            rg.setId(id);
            rg.setTrabajo(trabajo);
            rg.setTrabajador(trabajador);
            rg.setRol(registro.rol());

            RegistroTrabajo resultado = repo.save(rg);
            return repo.buscarPorId(resultado.getTrabajo().getIdTrabajo(), resultado.getTrabajador().getIdTrabajador()).get();
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ya existe un registro de trabajo con estos ids");
        }
    }

    public RegistroTrabajoDTO modificar(RegistroTrabajoDTO registro) {
        RegistroTrabajoId id = new RegistroTrabajoId(registro.idTrabajo(), registro.idTrabajador());
        RegistroTrabajo comprobante = repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "No existe ningun registro de trabajo con estos ids"));

        comprobante.setRol(registro.rol());

        RegistroTrabajo resultado = repo.save(comprobante);
        return repo.buscarPorId(resultado.getTrabajo().getIdTrabajo(), resultado.getTrabajador().getIdTrabajador()).get();
    }

    public void eliminar(int idTrabajo, int idTrabajador) {
        RegistroTrabajoId id = new RegistroTrabajoId(idTrabajo, idTrabajador);
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No existe ningun registro de trabajo con estos ids");
        }
    }
}
