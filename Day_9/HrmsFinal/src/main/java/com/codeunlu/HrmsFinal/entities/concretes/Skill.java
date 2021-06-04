package com.codeunlu.HrmsFinal.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "skills")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","candidateSkills"})
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "skill_name")
    @NotNull
    @NotBlank
    private String skillName;

    @JsonIgnore
    @OneToMany(mappedBy = "skill")
    private List<CandidateSkill> candidateSkills;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
}
