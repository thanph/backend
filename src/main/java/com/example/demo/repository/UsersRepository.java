package com.example.demo.repository;

import com.example.demo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UsersRepository {
// @Query(value = "SELECT * FROM user WHERE username =:name ",nativeQuery = true)
 List<UserEntity> getUser(String name);

// @Query(value = "SELECT * FROM user WHERE username =:name ",nativeQuery = true)
 List<UserEntity> getUser1(String name);


 Long countUser();
}
