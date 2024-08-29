package com.example.team_project.controllers;

import com.example.team_project.entities.User;
import com.example.team_project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Create a new user
    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        return userService.createNewUser(user);
    }

    // Get a list of all users
    @GetMapping("/list")
    public List<User> listUsers() {
        return userService.listUsers();
    }

    // Get a user by ID
    @GetMapping("/search/{id}")
    public ResponseEntity<User> searchUserById(@PathVariable Integer id) {
        Optional<User> user = userService.getUserById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    // Update a user by ID
    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody User user) {
        Optional<User> currentUser = userService.updateUser(id, user);
        if (currentUser.isPresent()) {
            return ResponseEntity.ok(currentUser.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Delete a user by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        Optional<User> currentUser = userService.getUserById(id);
        if (currentUser.isPresent()) {
            userService.deleteUser(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Deactivate a user by ID
    @PatchMapping("/{id}/deactivate")
    public ResponseEntity<Void> deactivateUser(@PathVariable Integer id) {
        Optional<User> currentUser = userService.getUserById(id);
        if (currentUser.isPresent()) {
            userService.deactivateUser(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
