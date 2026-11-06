package br.com.spring.jpa.repository;

import br.com.spring.jpa.model.Session;
import br.com.spring.jpa.model.Subscription;
import br.com.spring.jpa.model.SubscriptionID;
import br.com.spring.jpa.model.User;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface SubscriptionRepository extends ListCrudRepository<Subscription, SubscriptionID> {
    List<Subscription> findByIdUser(User user);
    List<Subscription> findByIdSession(Session session);
}