package com.winlentia.springbootexample.controller;

import java.util.List;

import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.winlentia.springbootexample.entity.User;
import com.winlentia.springbootexample.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController
{
    @Autowired
    UserService userService;

    @RequestMapping(value = "/users/", method = RequestMethod.GET)
    public ResponseEntity<List<User>> listAllUsers()
    {
        List<User> users = userService.findAllUsers();
        if(users.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/{id}/" , method = RequestMethod.GET)
    public ResponseEntity<?> getUser(@PathVariable("id") long id ){
        User user =  userService.findById(id);
        return new ResponseEntity<User>(user , HttpStatus.OK);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable("id") long id) {


        User user = userService.findById(id);
        if (user == null) {

            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        userService.deleteUserById(id);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }



}
