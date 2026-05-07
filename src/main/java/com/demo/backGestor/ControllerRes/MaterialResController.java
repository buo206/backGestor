package com.demo.backGestor.ControllerRes;

import com.demo.backGestor.Dto.MaterialListaDTO;
import com.demo.backGestor.Dto.TrabajadorDTO;
import com.demo.backGestor.Service.MaterialService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/res/material")
public class MaterialResController {
    private final MaterialService service ;

    public MaterialResController(MaterialService service) {
        this.service = service;
    }


    @GetMapping("/listar/{idEmpresa}")
    public ResponseEntity<List<MaterialListaDTO>> listar(@PathVariable int idEmpresa ){
        List<MaterialListaDTO> lista = service.listar(idEmpresa);
        return ResponseEntity.ok(lista);
    }


    @PostMapping("/editar")
    public ResponseEntity<MaterialListaDTO> modificar(@RequestBody MaterialListaDTO material){
        MaterialListaDTO tr = service.modificar(material);
        return ResponseEntity.ok(tr);
    }
}
