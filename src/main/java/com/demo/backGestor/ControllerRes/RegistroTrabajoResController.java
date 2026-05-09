package com.demo.backGestor.ControllerRes;

import com.demo.backGestor.Dto.RegistroTrabajoDTO;
import com.demo.backGestor.Service.RegistroTrabajoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/res/registroTrabajo")
public class RegistroTrabajoResController {
    private final RegistroTrabajoService service;

    public RegistroTrabajoResController(RegistroTrabajoService service) {
        this.service = service;
    }

    @GetMapping("/listar/{idEmpresa}")
    public ResponseEntity<List<RegistroTrabajoDTO>> listar(@PathVariable int idEmpresa) {
        List<RegistroTrabajoDTO> lista = service.listar(idEmpresa);
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/buscarRegistroTrabajo/{idTrabajo}")
    public ResponseEntity<List<RegistroTrabajoDTO>> buscarPorTrabajo(@PathVariable int idTrabajo) {
        List<RegistroTrabajoDTO> lista = service.buscarPorTrabajo(idTrabajo);
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/buscarRegistroTrabajador/{idTrabajador}")
    public ResponseEntity<List<RegistroTrabajoDTO>> buscarPorTrabajador(@PathVariable int idTrabajador) {
        List<RegistroTrabajoDTO> lista = service.buscarPorTrabajador(idTrabajador);
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/buscar/{idTrabajo}/{idTrabajador}")
    public ResponseEntity<RegistroTrabajoDTO> buscar(@PathVariable int idTrabajo, @PathVariable int idTrabajador) {
        RegistroTrabajoDTO registro = service.buscar(idTrabajo, idTrabajador);
        return ResponseEntity.ok(registro);
    }

    @PostMapping("/alta")
    public ResponseEntity<RegistroTrabajoDTO> nuevo(@RequestBody RegistroTrabajoDTO registro) {
        RegistroTrabajoDTO tr = service.nuevo(registro);
        return ResponseEntity.ok(tr);
    }

    @PostMapping("/editar")
    public ResponseEntity<RegistroTrabajoDTO> modificar(@RequestBody RegistroTrabajoDTO registro) {
        RegistroTrabajoDTO tr = service.modificar(registro);
        return ResponseEntity.ok(tr);
    }

    @DeleteMapping("/eliminar/{idTrabajo}/{idTrabajador}")
    public ResponseEntity<Void> eliminar(@PathVariable int idTrabajo, @PathVariable int idTrabajador) {
        service.eliminar(idTrabajo, idTrabajador);
        return ResponseEntity.noContent().build();
    }
}
