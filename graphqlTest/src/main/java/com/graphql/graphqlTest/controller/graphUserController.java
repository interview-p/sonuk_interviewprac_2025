package com.graphql.graphqlTest.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.graphql.graphqlTest.Entity.User;
import com.graphql.graphqlTest.service.UserService;

@Controller
public class graphUserController {

	private final UserService userService;

    public graphUserController(UserService userService) {
        this.userService = userService;
    }

    // ========================
    // Queries
    // ========================

    @QueryMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @QueryMapping
    public User getUserById(@Argument Integer id) {
        return userService.getUserById(id).orElse(null);
    }

    // ========================
    // Mutations
    // ========================

    @MutationMapping
    public User createUser(@Argument String name, @Argument String email, @Argument Integer age) {
        User user = new User();
        user.setUsername(name);
        user.setEmail(email);
        return userService.createUser(user);
    }

    @MutationMapping
    public Boolean deleteUser(@Argument Integer id) {
        userService.deleteUser(id);
        return true;
    }

    
}
