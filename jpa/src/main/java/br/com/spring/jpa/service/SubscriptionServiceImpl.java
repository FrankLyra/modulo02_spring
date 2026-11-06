package br.com.spring.jpa.service;

import br.com.spring.jpa.model.Session;
import br.com.spring.jpa.model.Subscription;
import br.com.spring.jpa.model.User;
import br.com.spring.jpa.repository.SubscriptionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class SubscriptionServiceImpl implements SubscriptionService{

    private final SubscriptionRepository subscriptionRepository;

    public SubscriptionServiceImpl(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    @Override
    public Subscription createSubscription(Subscription subscription) {
        subscription.setCreatedAt(LocalDateTime.now());
        subscription.setUniqueID(UUID.randomUUID().toString());
        return subscriptionRepository.save(subscription);
    }

    @Override
    public List<Subscription> findAllByUser(User user) {
        return subscriptionRepository.findByIdUser(user);
    }

    @Override
    public List<Subscription> findAllBySession(Session session) {
        return subscriptionRepository.findByIdSession(session);
    }
}
