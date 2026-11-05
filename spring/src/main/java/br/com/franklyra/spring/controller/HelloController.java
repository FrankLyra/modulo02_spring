package br.com.franklyra.spring.controller;

import br.com.franklyra.spring.model.Produto;
import org.springframework.web.bind.annotation.*;

@RestController()
public class HelloController {

 @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }
}
