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

    public User createNewUser(User user) {
        return userRepository.save(user);
    }

    public List<User> listUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(Math.toIntExact(id));
    }

    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new IllegalStateException("User not found"));

        user.setFirstName(userDetails.getFirstName());
        user.setLastName(userDetails.getLastName());
        user.setEmail(userDetails.getEmail());
        user.setActive(userDetails.isActive());
        user.setDocumentType(userDetails.getDocumentType());

        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        User user = userRepository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new IllegalStateException("User not found"));
        userRepository.delete(user);
    }

    public void deactivateUser(Long id) {
        User user = userRepository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new IllegalStateException("User not found"));
        user.setActive(false);
        userRepository.save(user);
    }
}
