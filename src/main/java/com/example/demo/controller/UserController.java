package com.example.demo.controller;

import com.example.demo.entity.EmployeeEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/get-all-user")
    public List<UserEntity> getAllUser() {
       return userService.getAllUser();
    }

    @GetMapping("/get-user/{name}")
    public List<UserEntity> getUser(@PathVariable String name){
        return userRepository.getUser1(name);
    }

    @GetMapping("/count")
    public Long countUser(){
        return userRepository.countUser();
    }
    @PostMapping("/insert")
    public EmployeeEntity insertEmployee(@RequestBody EmployeeEntity employeeEntity){
        userService.insertEmployee(employeeEntity);
        return employeeEntity;
    }
    @PostMapping("/register")
    public UserEntity insertUser(@RequestBody UserEntity userEntity)  {
        userService.insertUser(userEntity);
        return userEntity;
    }
    @PostMapping("/delete")
    public void deleteUser(@RequestBody Integer userId)  {
        userService.deleteUser(userId);
    }
}
