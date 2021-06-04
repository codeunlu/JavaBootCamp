package com.codeunlu.HrmsFinal.dataAccess.abstracts;

import com.codeunlu.HrmsFinal.entities.concretes.Workplace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkplaceDao extends JpaRepository<Workplace,Integer> {
}
