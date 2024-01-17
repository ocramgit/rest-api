package com.mindera.users.service;

import com.mindera.users.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    private List<User> userList;
    private Integer auto_increment = 0;

    public UsersService(List<User> userList) {
        this.userList = userList;
    }

    public User createUser(String name) {
        User user = new User(auto_increment, name);
        auto_increment += 1;
        userList.add(user);
        return user;
    }

    public List<User> getUserByName(String name) {
        List<User> users = userList.stream()
                .filter(e -> e.getName().equals(name))
                .findAny()
                .stream().toList();

        return users;
    }

    public User getUser(Integer id) {
        for (User user : userList) {
            if(user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public List<User> getAllUsers() {
        return userList;
    }

    public User updateUser(Integer id, String name) {
        Optional<User> user = userList.stream().filter(e -> e.getId() == id)
                .findFirst();

        if(user.isPresent()) {
            User userToUpdate = user.get();
            userToUpdate.setName(name);
            return userToUpdate;
        }
        return null;
    }
}
