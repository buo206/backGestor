package com.demo.backGestor.ControllerRes;

import com.demo.backGestor.Dto.LoginDTO;
import com.demo.backGestor.Dto.TrabajadorDTO;
import com.demo.backGestor.Dto.TrabajadorListaDTO;
import com.demo.backGestor.Service.TrabajadorService;
import com.demo.backGestor.modelos.Empresa;
import com.demo.backGestor.modelos.Trabajador;
import org.apache.commons.logging.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/res/trabajador")
public class TrabajadorResController {
    private final TrabajadorService service ;

    public TrabajadorResController(TrabajadorService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public ResponseEntity<TrabajadorDTO> login(@RequestBody LoginDTO login){
        TrabajadorDTO trabajador = service.validarEmailPassword(login.email() , login.password());
        return ResponseEntity.ok(trabajador);
    }

    @GetMapping("/listar/{idEmpresa}")
    public ResponseEntity<List<TrabajadorListaDTO>> listar(@PathVariable int idEmpresa ){
       List<TrabajadorListaDTO> lista = service.listar(idEmpresa);
       return ResponseEntity.ok(lista);
    }

    @PostMapping("/alta")
    public ResponseEntity<TrabajadorDTO> crear(@RequestBody Trabajador trabajador){
        TrabajadorDTO tr = service.crear(trabajador);
        return ResponseEntity.ok(tr);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<TrabajadorDTO> buscarPorId(@PathVariable int id) {
        TrabajadorDTO tr = service.buscarId(id);
        return ResponseEntity.ok(tr);
    }
}
