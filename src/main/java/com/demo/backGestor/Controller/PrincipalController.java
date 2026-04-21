package com.demo.backGestor.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PrincipalController {

    @GetMapping("")
    public String iniciar(){
        //lama a vista indez.html
        return "index.html";
    }
}
