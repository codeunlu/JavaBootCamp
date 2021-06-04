package com.codeunlu.HrmsFinal.dataAccess.abstracts;

import com.codeunlu.HrmsFinal.entities.concretes.CandidateEducation;
import com.codeunlu.HrmsFinal.entities.concretes.CandidateExperience;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidateExperienceDao extends JpaRepository<CandidateExperience,Integer> {
    List<CandidateExperience> getCandidateExperienceByCandidate_IdOrderByEndYearDesc(int id);
}
