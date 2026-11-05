package br.com.franklyra.spring.controller;

import br.com.franklyra.spring.model.Produto;
import br.com.franklyra.spring.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
public class HelloController {

    @Autowired
    private MessageService messageService;

 @GetMapping("/hello")
    public String hello() {
        return messageService.getMessage();
    }
}
