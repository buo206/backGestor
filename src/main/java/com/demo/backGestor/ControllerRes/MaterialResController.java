package com.demo.backGestor.ControllerRes;

import com.demo.backGestor.Dto.MaterialDTO;
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
    public ResponseEntity<List<MaterialDTO>> listar(@PathVariable int idEmpresa ){
        List<MaterialDTO> lista = service.listar(idEmpresa);
        return ResponseEntity.ok(lista);
    }


    @PostMapping("/editar")
    public ResponseEntity<MaterialDTO> modificar(@RequestBody MaterialDTO material){
        MaterialDTO tr = service.modificar(material);
        return ResponseEntity.ok(tr);
    }

    @PostMapping("/alta")
    public ResponseEntity<MaterialDTO> crear(@RequestBody MaterialDTO material){
        MaterialDTO tr = service.crear(material);
        return ResponseEntity.ok(tr);
    }
}
