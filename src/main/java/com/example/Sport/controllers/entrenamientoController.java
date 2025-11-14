package com.example.Sport.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.Sport.models.entrenamientoModel;
import com.example.Sport.services.entreamientoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class entrenamientoController {

    @Autowired
    private entreamientoService trenoService;




}
