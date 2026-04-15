package com.demo.backGestor.Controller;

import com.demo.backGestor.Dto.LoginEmpresaDTO;
import com.demo.backGestor.Service.EmpresaService;
import com.demo.backGestor.modelos.Empresa;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    private final EmpresaService service;

    public EmpresaController(EmpresaService service) {
        this.service = service;
    }

    // 1. Buscar empresa por ID
    @GetMapping("/{id}")
    public Empresa buscarPorId(@PathVariable int id) {
        return service.buscarId(id);
    }

    // 2. Validar email + password (login)
    @PostMapping("/login")
    public Empresa login(@RequestBody LoginEmpresaDTO login) {
        return service.validarEmailPassword(login.email(), login.password());
    }

    // devolver codigo http que te diga que ha pasado 201 200 202 , 404 etc
    @PostMapping
    public Empresa crear(@RequestBody Empresa empresa) {
        return service.crear(empresa);
    }
}

