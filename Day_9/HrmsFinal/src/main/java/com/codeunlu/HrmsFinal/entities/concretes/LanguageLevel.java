package com.codeunlu.HrmsFinal.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "languages_levels")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","candidateLanguages"})
public class LanguageLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "language_id")
    private Language language;

    @Column(name = "level")
    @NotNull
    private short level;

    @JsonIgnore
    @OneToMany(mappedBy = "languageLevel")
    private List<CandidateLanguage> candidateLanguages;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
}
