package br.com.spring.jpa.controller;

import br.com.spring.jpa.model.Conference;
import br.com.spring.jpa.service.ConferenceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConferenceController {

    private final ConferenceService conferenceService;

    public ConferenceController(ConferenceService conferenceService) {
        this.conferenceService = conferenceService;
    }

    @PostMapping("/conferences")
    public ResponseEntity<Conference> createConference(@RequestBody Conference conference) {
        return ResponseEntity.ok(conferenceService.addConference(conference));
    }

    @GetMapping("/conferences/{id}")
    public ResponseEntity<Conference> getConference(@PathVariable Integer id) {
        return ResponseEntity.ok(conferenceService.getConference(id));
    }

    @GetMapping("/conferences")
    public ResponseEntity<List<Conference>> getAllConferences() {
        return ResponseEntity.ok(conferenceService.getAllConferences());
    }
}
