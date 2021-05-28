package com.codeunlu.HrmsOdev.dataAccess.abstracts;

import com.codeunlu.HrmsOdev.entities.concretes.Verifaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VerifactionDao extends JpaRepository<Verifaction,Integer> {
    List<Verifaction> findAllByCode(String code);
    List<Verifaction> findAllByUserId(int userId);
}
