package com.demo.backGestor.ControllerRes;

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
    public ResponseEntity<Empresa> buscarPorId(@PathVariable int id) {
        Empresa empresa = service.buscarId(id);
        return ResponseEntity.ok(empresa);
    }

    //email y password
    @PostMapping("/login")
    public ResponseEntity<Empresa> login(@RequestBody LoginDTO login) {
        Empresa empresa = service.validarEmailPassword(login.email(), login.password());
        return ResponseEntity.ok(empresa); // 200 OK
    }

    //se usa para registrar empresas
    @PostMapping("/alta")
    public ResponseEntity<Empresa> crear(@RequestBody Empresa empresa) {
        Empresa creada = service.crear(empresa);
        return ResponseEntity.status(HttpStatus.CREATED).body(creada); // 201 CREATED
    }
}

