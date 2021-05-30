package com.codeunlu.HrmsFinal.dataAccess.abstracts;

import com.codeunlu.HrmsFinal.entities.concretes.VerifactionEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerifactionEmployeeDao extends JpaRepository<VerifactionEmployee,Integer> {
}
