package com.codeunlu.HrmsFinal.entities.concretes;

import com.codeunlu.HrmsFinal.core.entities.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id")
@Table(name = "candidates")
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler",
        "candidateResume",
        "candidateEducation",
        "candidateExperience",
        "candidateLanguage",
        "candidateSocial",
        "candidateSkill"})
public class Candidate extends User {
    @Column(name = "name")
    @NotBlank
    @NotNull
    private String name;

    @Column(name = "surname")
    @NotBlank
    @NotNull
    private String surname;

    @Column(name = "national_id",length = 11)
    @NotBlank
    @NotNull
    private String nationalId;

    @Column(name = "date_of_birth")
    @NotNull
    private LocalDate dateofBirth;

    @Column(name = "is_verified")
    private boolean isVerified;

    @JsonIgnore
    @OneToOne(mappedBy = "candidate")
    private CandidateResume candidateResume;

    @JsonIgnore
    @OneToMany(mappedBy = "candidate")
    private List<CandidateEducation> candidateEducations;

    @JsonIgnore
    @OneToMany(mappedBy = "candidate")
    private  List<CandidateExperience> candidateExperiences;

    @JsonIgnore
    @OneToMany(mappedBy = "candidate")
    private  List<CandidateLanguage> candidateLanguages;

    @JsonIgnore
    @OneToMany(mappedBy = "candidate")
    private  List<CandidateSocial> candidateSocials;

    @JsonIgnore
    @OneToMany(mappedBy = "candidate")
    private  List<CandidateSkill> candidateSkills;

}
