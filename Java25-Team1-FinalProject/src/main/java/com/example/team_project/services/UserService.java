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
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Retrieve a list of all users from the database
    public List<User> listUsers() {
        return userRepository.findAll();
    }

    // Find a user by their ID
    public Optional<User> searchUserById(Integer id) {
        if (userRepository.existsById(id)) {
            return userRepository.findById(id);
        } else {
            return Optional.empty();
        }
    }

    // Update an existing user by their ID
    public Optional<User> updateUser(Integer id, User user) {
        Optional<User> currentUserOpt = userRepository.findById(id);
        if (currentUserOpt.isPresent()) {
            currentUserOpt.get().setEmail(user.getEmail());
            currentUserOpt.get().setFirstName(user.getFirstName());
            currentUserOpt.get().setLastName(user.getLastName());
            currentUserOpt.get().setPhone(user.getPhone());
            currentUserOpt.get().setDocumentType(user.getDocumentType());
            currentUserOpt.get().setDocumentNumber(user.getDocumentNumber());
            currentUserOpt.get().setEmployeeRole(user.getEmployeeRole());
            currentUserOpt.get().setIsActive(user.getIsActive());

            userRepository.save(currentUserOpt.get());
            return currentUserOpt;
        } else {
            return Optional.empty();
        }
    }

    // Delete a user by their ID
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    // Deactivate a user by setting their active status to false
    public Optional<User> deactivateUser(Integer id) {
        Optional<User> currentUser = userRepository.findById(id);
        if (currentUser.isPresent()) {
            User user = currentUser.get();
            user.setIsActive(false);
            userRepository.save(user);
            return Optional.of(user);
        } else {
            return Optional.empty();
        }
    }
}