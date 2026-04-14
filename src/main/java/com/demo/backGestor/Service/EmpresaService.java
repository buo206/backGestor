package com.demo.backGestor.Service;

import com.demo.backGestor.Repository.EmpresaRepository;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService {
    private final EmpresaRepository repo ;

    public EmpresaService(EmpresaRepository repo) {
        this.repo = repo;
    }


}
