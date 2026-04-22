package com.demo.backGestor.Controller;

import com.demo.backGestor.Dto.TrabajoListaDTO;
import com.demo.backGestor.Service.TrabajoService;
import com.demo.backGestor.modelos.Trabajo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/trabajo")
public class TrabajoController {
    private final TrabajoService service ;

    public TrabajoController(TrabajoService service) {
        this.service = service;
    }


    @GetMapping("/listar/{idEmpresa}")
    public String listar(@PathVariable int idEmpresa , Model model){
        List<TrabajoListaDTO> lista = service.lista(idEmpresa);
        model.addAttribute("trabajos" , lista);
        return "trabajoLista.html";
    }

    @GetMapping("/editar/{idTrabajo}")
    public String editar(@PathVariable int idTrabajo , Model model){
        model.addAttribute("trabajo", service.buscar(idTrabajo)) ;
        return "EditarTrabajo.html" ;
    }

    @GetMapping("nuevo/{idEmpresa}")
    public String nuevo(@PathVariable int idEmpresa , Model model){
        model.addAttribute("trabajo", service.nuevo(idEmpresa)) ;
        return "EditarTrabajo.html" ;
    }

    @PostMapping("/guardar")
    public String guardarCliente(@ModelAttribute Trabajo trabajo){
        service.guardar(trabajo) ;
        return "redirect:listar/"+2;
    }

    @GetMapping("eliminar/{idTrabajo}")
    public String eliminar(@PathVariable int idTrabajo , Model model){
        service.eliminar(idTrabajo);
        List<TrabajoListaDTO> lista = service.lista(2);
        model.addAttribute("trabajos" , lista);
        return "trabajoLista.html";
    }
}
