package com.mindera.users.service;

import com.mindera.users.exceptions.UserNotFoundException;
import com.mindera.users.model.User;
import com.mindera.users.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository = new UserRepository();
    private Integer auto_increment = 0;

    public User createUser(String name) {
        User user = new User(auto_increment, name);
        auto_increment += 1;
        userRepository.getAllUsers().add(user);
        return user;
    }

    public List<User> getUserByName(String name) {
        List<User> users = userRepository.getAllUsers().stream()
                .filter(e -> e.getName().equals(name))
                .findAny()
                .stream().toList();

        return users;
    }

    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public Optional<User> getUser(Integer id) {

        return userRepository.getAllUsers().stream()
                .filter(e -> e.getId() == id)
                .
    }

    public void delete(Integer id) {
        User user = userRepository.getAllUsers().stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .get();

        userRepository.getAllUsers().remove(user);
    }

    public User updateUser(Integer id, String name) {
        Optional<User> user = userRepository.getAllUsers().stream()
                .filter(e -> e.getId() == id)
                .findFirst();

        if(user.isPresent()) {
            User userToUpdate = user.get();
            userToUpdate.setName(name);
            return userToUpdate;
        }
        try {
            throw new UserNotFoundException();
        } catch (UserNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}