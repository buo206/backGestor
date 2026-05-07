package com.demo.backGestor.ControllerRes;


import com.demo.backGestor.Dto.TrabajoDTO;
import com.demo.backGestor.Dto.TrabajoListaDTO;
import com.demo.backGestor.Service.TrabajoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/res/trabajo")
public class TrabajoResController {
    private final TrabajoService service ;

    public TrabajoResController(TrabajoService service) {
        this.service = service;
    }

    @GetMapping("/listar/{idEmpresa}")
    public ResponseEntity<List<TrabajoListaDTO>> listar(@PathVariable int idEmpresa ){
        List<TrabajoListaDTO> lista = service.listar(idEmpresa);
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<TrabajoDTO> buscarPorId(@PathVariable int id) {
        TrabajoDTO tr = service.buscar(id);
        return ResponseEntity.ok(tr);
    }
}
