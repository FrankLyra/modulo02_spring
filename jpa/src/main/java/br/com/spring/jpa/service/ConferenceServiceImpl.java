package br.com.spring.jpa.service;

import br.com.spring.jpa.exception.NotFoundException;
import br.com.spring.jpa.model.Conference;
import br.com.spring.jpa.repository.ConferenceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConferenceServiceImpl implements ConferenceService {

    private final ConferenceRepository conferenceRepository;

    public ConferenceServiceImpl(ConferenceRepository conferenceRepository) {
        this.conferenceRepository = conferenceRepository;
    }

    @Override
    public Conference addConference(Conference conference) {
        return conferenceRepository.save(conference);
    }

    @Override
    public Conference getConference(Integer id) {
        return conferenceRepository.findById(id).orElseThrow(() -> new NotFoundException("Conference " + id + " not found"));
    }

    @Override
    public List<Conference> getAllConferences() {
        return conferenceRepository.findAll();
    }
}
