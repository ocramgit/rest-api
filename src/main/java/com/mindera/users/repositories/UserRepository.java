package com.mindera.users.repositories;

import com.mindera.users.model.User;

import java.util.LinkedList;
import java.util.List;

public class UserRepository {

    private List<User> userList = new LinkedList<>();

    public List<User> getAllUsers() {
        return userList;
    }
}
