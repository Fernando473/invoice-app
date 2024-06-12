package com.altioracorp.evaluation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/")
    public String hello() {
        return "Hola mundo desde SpringM AH0RA HACIENDO UN CAMBIO agregando un cambio nuevo OOO FINE IT WORKS";
    }

    @GetMapping("modified/")
    public String modified() {
        return "Esta es una nueva ruta, cambiando el comportamiento de la ruta, ahora es una nueva rutaaaaaaaaaaaaaaaa agkjhsdjkghsdfjghsjdfhgsdfg";
    }
}
