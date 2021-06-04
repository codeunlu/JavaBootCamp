package com.codeunlu.HrmsFinal.dataAccess.abstracts;

import com.codeunlu.HrmsFinal.entities.concretes.CandidateResume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateResumeDao extends JpaRepository<CandidateResume,Integer> {
}
