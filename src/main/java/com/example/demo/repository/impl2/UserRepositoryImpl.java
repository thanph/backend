package com.example.demo.repository.impl2;

import com.example.demo.entity.EmployeeEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UsersRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component("special")
public class UserRepositoryImpl implements UsersRepository {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List getUser(String name) {
        String sql = "FROM user u WHERE u.username = :name ";
      return  entityManager.createQuery(sql, UserEntity.class).setParameter("name", name).getResultList();
    }

    @Override
    public List getUser1(String name) {
        String sql = "SELECT * FROM UserEntity WHERE username = :name ";
        return  entityManager.createQuery(sql, UserEntity.class).setParameter("name", name).getResultList();
    }

    @Override
    public Long countUser() {
        Query query = entityManager.createQuery("SELECT COUNT(e.id) FROM EmployeeEntity e", EmployeeEntity.class);
        return (Long) query.getSingleResult();
    }
}