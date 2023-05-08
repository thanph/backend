package com.example.demo.controller;

import com.example.demo.DTO.LoginDTO;
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
        return null;
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

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO){
        return ResponseEntity.ok( userService.login(loginDTO));
    }
}
