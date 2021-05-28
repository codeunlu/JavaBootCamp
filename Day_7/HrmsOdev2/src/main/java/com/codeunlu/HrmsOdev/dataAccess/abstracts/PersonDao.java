package com.codeunlu.HrmsOdev.dataAccess.abstracts;

import com.codeunlu.HrmsOdev.entities.concretes.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonDao extends JpaRepository<Person,Integer> {
    List<Person> findAllByEmail(String email);
}
