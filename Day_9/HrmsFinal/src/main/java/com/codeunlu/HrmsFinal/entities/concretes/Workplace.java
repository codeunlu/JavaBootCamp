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
@Table(name = "workplaces")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","candidateExperience"})
public class Workplace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "workplace_name")
    @NotBlank
    @NotNull
    private String workplaceName;

    @JsonIgnore
    @OneToMany(mappedBy = "workplace")
    private List<CandidateExperience> candidateExperience;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
}
