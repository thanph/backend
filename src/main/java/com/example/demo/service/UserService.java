package com.example.demo.service;

import com.example.demo.entity.EmployeeEntity;
import com.example.demo.entity.UserEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    List<UserEntity> getAllUser();

    List<UserEntity> getUser(String name);

    void insertUser(UserEntity userEntity) ;

    void insertEmployee(EmployeeEntity employeeEntity);

    void deleteUser(Integer userId);

    void updateUser(UserEntity userEntity);
}
