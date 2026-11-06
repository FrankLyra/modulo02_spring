package br.com.spring.jpa.controller;

import br.com.spring.jpa.model.Session;
import br.com.spring.jpa.model.Subscription;
import br.com.spring.jpa.model.User;
import br.com.spring.jpa.service.SubscriptionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubscriptionController {

    private SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @PostMapping("/subscriptions")
    public ResponseEntity<Subscription> createSubscription(@RequestBody Subscription subscription) {
        Subscription createdSubscription = subscriptionService.createSubscription(subscription);
        return ResponseEntity.ok(createdSubscription);
    }

    @GetMapping("/subscriptions/user/{userId}")
    public ResponseEntity<List<Subscription>> getSubscriptionsByUser(@PathVariable Integer userId) {
        User user = new User();
        user.setUserId(userId);
        return ResponseEntity.ok(subscriptionService.findAllByUser(user));
    }

    @GetMapping("/subscriptions/session/{sessionId}")
    public ResponseEntity<List<Subscription>> getSubscriptionsBySession(@PathVariable Integer sessionId) {
        Session session = new Session();
        session.setIdSession(sessionId);
        return ResponseEntity.ok(subscriptionService.findAllBySession(session));
    }


}
