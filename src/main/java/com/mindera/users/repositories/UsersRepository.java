package com.mindera.users.repositories;

import com.mindera.users.model.User;

import java.util.List;

public interface UsersRepository {

    List<User> getAllUsers();
    User createUser(String name);
    User getUser(Integer id);
    User updateUser(Integer id);
}
