package com.codeunlu.HrmsFinal.core.dataAccess;

import com.codeunlu.HrmsFinal.core.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserDao extends JpaRepository<User,Integer> {
    User findByEmail(String email);
    User findById(int id);
}
