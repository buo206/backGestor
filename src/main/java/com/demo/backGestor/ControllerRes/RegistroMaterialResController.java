package com.demo.backGestor.ControllerRes;


import com.demo.backGestor.Dto.RegistroMaterialDTO;
import com.demo.backGestor.Service.RegistroMaterialService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/res/registroMaterial")
public class RegistroMaterialResController {
    private final RegistroMaterialService service ;

    public RegistroMaterialResController(RegistroMaterialService service) {
        this.service = service;
    }

    @GetMapping("/listar/{idEmpresa}")
    public ResponseEntity<List<RegistroMaterialDTO>> listar(@PathVariable int idEmpresa ){
        List<RegistroMaterialDTO> lista = service.listar(idEmpresa);
        return ResponseEntity.ok(lista);
    }
}
