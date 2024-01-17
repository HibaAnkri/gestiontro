package org.example.Service;

import org.example.Entity.User;
import org.example.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    public UserRepository userRepository;

    public boolean isUserPresent(String username,String password) {

        User user =userRepository.findByUsername(username);
        if(user==null)
            return false;
        return password.equals(user.getPassword());

    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    // In UserService class
    public User updateUser(Long userId, User userModified) {
        Optional<User> existingUser = userRepository.findById(userId);

        if (existingUser.isPresent()) {
            User updatedUser = existingUser.get();
            updatedUser.setUsername(userModified.getUsername());
            updatedUser.setPassword(userModified.getPassword());
            // Ignore roles during update
            // updatedUser.setRoles(userModified.getRoles());

            return userRepository.save(updatedUser);
        } else {
            return null;
        }
    }


    public User findUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }
}
