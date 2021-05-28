package com.codeunlu.HrmsOdev.dataAccess.abstracts;

import com.codeunlu.HrmsOdev.entities.concretes.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidateDao extends JpaRepository<Candidate,Integer> {
    List<Candidate> findAllByEmail(String email);
    List<Candidate> findAllByNationalId(String nationalId);
    List<Candidate> findAllById(int id);
}
