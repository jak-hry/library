package com.example.user;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/list")
    public List<User> findAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/get/{id}")
    public User findUserById(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    @DeleteMapping("/remove/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
