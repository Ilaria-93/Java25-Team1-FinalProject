package com.example.team_project.services;

import com.example.team_project.entities.User;
import com.example.team_project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Create a new user in the database

    public User createNewUser(User user) {
        return userRepository.save(user);
    }

    // Retrieve a list of all users from the database

    public List<User> listUsers() {
        return userRepository.findAll();
    }

    // Find a user by their ID

    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    // Update an existing user by their ID

    public User updateUser(Integer id, User userDetails) {
        if (userRepository.existsById(id)) {
            userDetails.setId(id);
            return userRepository.save(userDetails);
        } else {
            throw new IllegalStateException("User not found");
        }
    }

    // Delete a user by their ID

    public void deleteUser(Integer id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new IllegalStateException("User not found");
        }

    }

    // Deactivate a user by setting their active status to false

    public void deactivateUser(Integer id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setActive(false);
            userRepository.save(user);
        } else {
            throw new IllegalStateException("User not found");
        }

    }
}