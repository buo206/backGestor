package com.demo.backGestor.ControllerRes;

import com.demo.backGestor.Dto.EmpresaDTO;
import com.demo.backGestor.Dto.LoginDTO;
import com.demo.backGestor.Service.EmpresaService;
import com.demo.backGestor.modelos.Empresa;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/res/empresa")
public class EmpresaResController {

    private final EmpresaService service;

    public EmpresaResController(EmpresaService service) {
        this.service = service;
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<EmpresaDTO> buscarPorId(@PathVariable int id) {
        EmpresaDTO empresa = service.buscarId(id);
        return ResponseEntity.ok(empresa);
    }

    //email y password
    @PostMapping("/login")
    public ResponseEntity<EmpresaDTO> login(@RequestBody LoginDTO login) {
        EmpresaDTO empresa = service.validarEmailPassword(login.email(), login.password());
        return ResponseEntity.ok(empresa); // 200 OK
    }

    //se usa para registrar empresas
    @PostMapping("/alta")
    public ResponseEntity<EmpresaDTO> crear(@RequestBody EmpresaDTO empresa) {
        EmpresaDTO creada = service.crear(empresa);
        return ResponseEntity.status(HttpStatus.CREATED).body(creada); // 201 CREATED
    }
}

