package br.com.spring.jpa.service;

import br.com.spring.jpa.exception.NotFoundException;
import br.com.spring.jpa.model.Session;
import br.com.spring.jpa.repository.SessionRepository;
import org.springframework.stereotype.Service;

import javax.imageio.spi.ServiceRegistry;
import java.util.List;

@Service
public class SessionServiceImpl implements SessionService {

    private final SessionRepository sessionRepo;

    public SessionServiceImpl(SessionRepository sessionRepo) {
        this.sessionRepo = sessionRepo;
    }


    @Override
    public Session getSessionById(Integer id) {
        return sessionRepo.findById(id).orElseThrow(() -> new NotFoundException("Session not found with id: " + id));
    }

    @Override
    public List<Session> getAllSessions() {
        return sessionRepo.findAll();
    }
}
