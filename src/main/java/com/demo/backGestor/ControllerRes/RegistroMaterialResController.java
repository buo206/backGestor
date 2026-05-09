package com.demo.backGestor.ControllerRes;


import com.demo.backGestor.Dto.RegistroMaterialDTO;
import com.demo.backGestor.Dto.TrabajoDTO;
import com.demo.backGestor.Service.RegistroMaterialService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/buscarRegistroTrabajo/{idTrabajo}")
    public ResponseEntity<List<RegistroMaterialDTO>> buscarPorTrabajo(@PathVariable int idTrabajo ){
        List<RegistroMaterialDTO> lista = service.buscarPorTrabajo(idTrabajo);
        return ResponseEntity.ok(lista);
    }

    @PostMapping("/editar")
    public ResponseEntity<RegistroMaterialDTO> modificar(@RequestBody RegistroMaterialDTO trabajo ){
        RegistroMaterialDTO tr = service.modificar(trabajo);
        return ResponseEntity.ok(tr);
    }

    @PostMapping("/alta")
    public ResponseEntity<RegistroMaterialDTO> nuevo(@RequestBody RegistroMaterialDTO trabajo ){
        RegistroMaterialDTO tr = service.nuevo(trabajo);
        return ResponseEntity.ok(tr);
    }

}
