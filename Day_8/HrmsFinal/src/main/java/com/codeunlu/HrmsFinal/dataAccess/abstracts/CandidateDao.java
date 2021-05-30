package com.codeunlu.HrmsFinal.dataAccess.abstracts;

import com.codeunlu.HrmsFinal.entities.concretes.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateDao extends JpaRepository<Candidate,Integer> {
    Candidate findByNationalId(String nationalId);
    Candidate findByEmail(String email);
    Candidate findById(int id);
}
