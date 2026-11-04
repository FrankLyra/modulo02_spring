package br.com.franklyra.spring.controller;

import br.com.franklyra.spring.model.Produto;
import org.springframework.web.bind.annotation.*;

@RestController()
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }

    @GetMapping("/produtos")
    public Produto produtos() {
        return new Produto(1L, "Produto 1", 10.0);
    }

    @PostMapping("/produtos")
    public Produto createProduto(@RequestBody Produto produto) {
        return produto;
    }

}
