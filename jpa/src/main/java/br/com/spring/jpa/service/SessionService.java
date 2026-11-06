package br.com.spring.jpa.service;

import br.com.spring.jpa.model.Session;

import java.util.List;

public interface SessionService {

    public Session getSessionById(Integer id);
    public List<Session> getAllSessions();
}
