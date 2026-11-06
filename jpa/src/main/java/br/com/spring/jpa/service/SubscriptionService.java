package br.com.spring.jpa.service;

import br.com.spring.jpa.model.Session;
import br.com.spring.jpa.model.Subscription;
import br.com.spring.jpa.model.User;

import java.util.List;

public interface SubscriptionService {

    public Subscription createSubscription(Subscription subscription);
    public List<Subscription> findAllByUser(User user);
    public List<Subscription> findAllBySession(Session session);
}
