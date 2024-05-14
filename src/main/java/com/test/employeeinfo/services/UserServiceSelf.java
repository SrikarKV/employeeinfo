package com.test.employeeinfo.services;

import com.test.employeeinfo.model.User;
import com.test.employeeinfo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceSelf implements UserService{

    private UserRepository userRepository;
    @Autowired
    public UserServiceSelf(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public User addUser(User user) {

        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {

        userRepository.deleteById(id);

    }

    @Override
    public User updateUser(Long id, User user) {
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()){
            User savedUser= userOptional.get();
            if(user.getUsername()!=null) savedUser.setUsername(user.getUsername());
            if(user.getPassword()!=null) savedUser.setPassword(user.getPassword());

            return userRepository.save(savedUser);
        }

        return null; // need to throw exception with message
    }

    @Override
    public User getUser(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()) return userOptional.get();
        return null; // need to throw exception with message
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
