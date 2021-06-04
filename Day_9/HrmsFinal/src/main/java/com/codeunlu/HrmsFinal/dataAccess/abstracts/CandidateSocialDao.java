package com.codeunlu.HrmsFinal.dataAccess.abstracts;

import com.codeunlu.HrmsFinal.entities.concretes.CandidateSocial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateSocialDao extends JpaRepository<CandidateSocial,Integer> {
}
