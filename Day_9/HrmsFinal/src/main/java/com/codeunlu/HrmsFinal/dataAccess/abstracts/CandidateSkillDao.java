package com.codeunlu.HrmsFinal.dataAccess.abstracts;

import com.codeunlu.HrmsFinal.entities.concretes.CandidateSkill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateSkillDao extends JpaRepository<CandidateSkill,Integer> {
}
