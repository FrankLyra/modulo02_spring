package br.com.spring.jpa.repository;

import br.com.spring.jpa.model.Conference;
import org.springframework.data.repository.ListCrudRepository;

public interface ConferenceRepository extends ListCrudRepository<Conference, Integer> {
}
