package com.codeunlu.HrmsOdev.dataAccess.abstracts;

import com.codeunlu.HrmsOdev.entities.concretes.Verifaction;
import com.codeunlu.HrmsOdev.entities.concretes.VerifactionPerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerifactionPersonDao extends JpaRepository<VerifactionPerson,Integer> {
}
