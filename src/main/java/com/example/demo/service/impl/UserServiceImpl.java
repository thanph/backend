package com.example.demo.service.impl;

import com.example.demo.DTO.LoginDTO;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserEntity> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public List<UserEntity> getUser(String name) {
        return null;
    }


    @Override
    public void insertUser(UserEntity userEntity) {
//        userEntity.domainOperation();
        userRepository.save(userEntity);
    }


    @Override
    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public void updateUser(UserEntity userEntity) {
        userRepository.save(userEntity);
    }

    @Override
    public UserEntity login(LoginDTO loginDTO) {
        Optional<UserEntity> optional = userRepository.findByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword());
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new RuntimeException();
        }
    }

    @Override
    public void editUser(UserEntity userEntity) {
        Optional<UserEntity> optional = userRepository.findById(userEntity.getId());
        if (optional.isEmpty()) {
            throw new RuntimeException();
        } else {
            UserEntity user = optional.get();
            if (userEntity.getUsername() != null) {
                user.setUsername(userEntity.getUsername());
            }
            if (userEntity.getPassword() != null) {
                user.setPassword(userEntity.getPassword());
            }
            if (userEntity.getUserType() != null) {
                user.setUserType(userEntity.getUserType());
            }
            if (userEntity.getEmail() != null) {
                user.setEmail(userEntity.getEmail());
            }
            if (userEntity.getPhoneNumber() != null) {
                user.setPhoneNumber(userEntity.getPhoneNumber());
            }
            userRepository.save(user);
        }
    }
}