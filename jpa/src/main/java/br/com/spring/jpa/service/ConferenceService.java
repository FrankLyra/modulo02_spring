package br.com.spring.jpa.service;

import br.com.spring.jpa.model.Conference;

import java.util.List;

public interface ConferenceService {
   public Conference addConference(Conference conference);
    public Conference getConference(Integer id);
    public List<Conference> getAllConferences();
}
