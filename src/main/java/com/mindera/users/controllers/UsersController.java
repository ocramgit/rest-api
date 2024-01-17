package com.mindera.users.controllers;

import com.mindera.users.model.User;
import com.mindera.users.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UsersController {

    private UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping(params = "id")
    public User getUser(@RequestParam Integer id) {
        return usersService.getUser(id);
    }

    @GetMapping(params = "name")
    public List<User> getUserByName(@RequestParam String name) {
        return usersService.getUserByName(name);
    }

    @GetMapping("/create")
    public User create(@RequestParam String name) {
        return usersService.createUser(name);
    }

    @GetMapping("/list")
    public List<User> getUserList() {
        return usersService.getAllUsers();
    }

    @GetMapping("/user/update")
    public User update(@RequestParam Integer id, String name) {
        return usersService.updateUser(id, name);
    }
}
