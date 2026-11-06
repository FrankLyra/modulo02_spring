package br.com.spring.jpa.controller;

import br.com.spring.jpa.model.Session;
import br.com.spring.jpa.service.SessionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SessionController {

    private final SessionService sessionService;

    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @GetMapping("/sessions/{id}")
    public ResponseEntity<Session> getSessionById(@PathVariable Integer id) {
        return ResponseEntity.ok(sessionService.getSessionById(id));
    }

    @GetMapping("/sessions")
    public ResponseEntity<List<Session>> getAllSessions() {
        return ResponseEntity.ok(sessionService.getAllSessions());
    }
}
