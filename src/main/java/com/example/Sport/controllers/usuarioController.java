package com.example.Sport.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class usuarioController {
    @GetMapping("/")
    public String verLogin(){
        return "index";
    }
}
