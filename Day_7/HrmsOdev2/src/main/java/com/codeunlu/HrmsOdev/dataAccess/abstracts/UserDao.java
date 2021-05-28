package com.codeunlu.HrmsOdev.dataAccess.abstracts;

import com.codeunlu.HrmsOdev.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao extends JpaRepository<User,Integer> {
    List<User> findAllById(int id);
}
