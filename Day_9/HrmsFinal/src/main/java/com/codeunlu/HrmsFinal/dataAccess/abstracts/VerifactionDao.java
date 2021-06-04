package com.codeunlu.HrmsFinal.dataAccess.abstracts;

import com.codeunlu.HrmsFinal.entities.concretes.Verifaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerifactionDao extends JpaRepository<Verifaction,Integer> {
    Verifaction getByCode(String code);
    Verifaction findByUserId(int id);
}
