package com.test.employeeinfo.services;

import com.test.employeeinfo.model.User;

import java.util.List;

public interface UserService {
    public User addUser(User user);
    public void deleteUser(Long id);
    public User updateUser(Long id,User user);
    public User getUser(Long id);
    public List<User> getAllUsers();
}
