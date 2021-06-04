package com.codeunlu.HrmsFinal.entities.dto;

import com.codeunlu.HrmsFinal.entities.concretes.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateResumeDto {
    private Candidate candidate;

    private List<CandidateEducation> candidateEducations;

    private List<CandidateExperience> candidateExperiences;

    private List<CandidateLanguage> candidateLanguages;

    private List<CandidateSocial> candidateSocials;

    private List<CandidateSkill> candidateSkills;

    private CandidateResume candidateResume;
}
