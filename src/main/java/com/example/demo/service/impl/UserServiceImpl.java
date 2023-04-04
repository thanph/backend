package com.example.demo.service.impl;

import com.example.demo.entity.EmployeeEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.EmloyeeRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EmloyeeRepository emloyeeRepository;

    @Override
    public List<UserEntity> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public List<UserEntity> getUser(String name) {
        return userRepository.getUser(name);
    }

    @Override
    public void insertUser(UserEntity userEntity)  {
//        userEntity.domainOperation();
        userRepository.save(userEntity);
    }

    @Override
    public void insertEmployee(EmployeeEntity employeeEntity) {
        emloyeeRepository.save(employeeEntity);
    }

    @Override
    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public void updateUser(UserEntity userEntity) {
        userRepository.save(userEntity);
    }
}
