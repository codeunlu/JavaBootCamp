package com.codeunlu.HrmsFinal.dataAccess.abstracts;

import com.codeunlu.HrmsFinal.entities.concretes.CandidateEducation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidateEducationDao extends JpaRepository<CandidateEducation,Integer> {
    List<CandidateEducation> getCandidateEducationByCandidate_IdOrderByEndYearDesc(int id);
}
