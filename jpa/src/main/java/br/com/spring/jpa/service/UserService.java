package br.com.spring.jpa.service;

import br.com.spring.jpa.model.User;

import java.util.List;

public interface UserService {
    public User addUser(User user);
    public User getUserById(Integer id);
    public User getUserByEmail(String email);
    public List<User> getAllUsers();
}
