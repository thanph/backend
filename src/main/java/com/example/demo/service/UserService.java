package com.example.demo.service;

import com.example.demo.DTO.LoginDTO;
import com.example.demo.entity.UserEntity;

import java.util.List;

public interface UserService {
    List<UserEntity> getAllUser();

    List<UserEntity> getUser(String name);

    void insertUser(UserEntity userEntity) ;


    void deleteUser(Integer userId);

    void updateUser(UserEntity userEntity);

    UserEntity login(LoginDTO loginDTO);
}
