package com.mindera.users.controllers;

import com.mindera.users.model.User;
import com.mindera.users.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private UserService usersService;

    @GetMapping("/{id}")
    public User getUser(@PathVariable Integer id) {
        return usersService.getUser(id);
    }

    @GetMapping(params = "name")
    public List<User> getUserByName(@RequestParam String name) {
        return usersService.getUserByName(name);
    }

    @PostMapping("/create")
    public User create(@RequestParam String name) {
        return usersService.createUser(name);
    }

    @GetMapping("/list")
    public List<User> getUserList() {
        return usersService.getAllUsers();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        usersService.delete(id);
    }

    @PatchMapping("/update")
    public User update(@RequestParam Integer id, @RequestParam String name) {
        return usersService.updateUser(id, name);
    }
}
