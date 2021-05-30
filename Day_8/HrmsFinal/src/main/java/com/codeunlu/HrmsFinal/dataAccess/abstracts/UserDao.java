package com.codeunlu.HrmsFinal.dataAccess.abstracts;

import com.codeunlu.HrmsFinal.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao extends JpaRepository<User,Integer> {
    List<User> findByEmail(String email);
    List<User> findById(int id);
}
