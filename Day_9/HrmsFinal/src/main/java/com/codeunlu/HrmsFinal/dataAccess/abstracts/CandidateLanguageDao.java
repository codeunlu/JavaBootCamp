package com.codeunlu.HrmsFinal.dataAccess.abstracts;

import com.codeunlu.HrmsFinal.entities.concretes.CandidateLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateLanguageDao extends JpaRepository<CandidateLanguage,Integer> {
}
