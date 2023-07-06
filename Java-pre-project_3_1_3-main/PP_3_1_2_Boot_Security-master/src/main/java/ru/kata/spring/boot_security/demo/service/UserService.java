package ru.kata.spring.boot_security.demo.service;

import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;


public interface UserService {
    public void save(User user);

    public void update(User user);

    public void deleteUser(Long id);

    List<User> getAllUsers();

    User findByUsername(String username);

    User getUserById(Long id);
}
