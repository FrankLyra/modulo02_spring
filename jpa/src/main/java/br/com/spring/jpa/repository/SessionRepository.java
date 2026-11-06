package br.com.spring.jpa.repository;

import br.com.spring.jpa.model.Session;
import org.springframework.data.repository.ListCrudRepository;

public interface SessionRepository extends ListCrudRepository<Session, Integer> {
}
