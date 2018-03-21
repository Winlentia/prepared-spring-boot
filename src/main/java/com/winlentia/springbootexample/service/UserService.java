package com.winlentia.springbootexample.service;

import java.util.List;

import com.winlentia.springbootexample.entity.User;

public interface UserService
{
    User findById(long id);

    User findByName(String name);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUserById(long id);

    List<User> findAllUsers();

    boolean isUserExist(User user);
}
