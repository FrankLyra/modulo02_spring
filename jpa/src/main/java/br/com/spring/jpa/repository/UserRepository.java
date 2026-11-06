package br.com.spring.jpa.repository;

import br.com.spring.jpa.model.User;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface UserRepository extends ListCrudRepository<User, Integer> {

        public Optional<User> findByMail(String mail);
}
